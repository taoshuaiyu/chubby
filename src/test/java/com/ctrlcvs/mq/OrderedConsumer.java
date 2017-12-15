package com.ctrlcvs.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.impl.consumer.ConsumeMessageOrderlyService;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.body.CMResult;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderedConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OrderedConsumerGroupName");
        consumer.setNamesrvAddr("192.168.0.25:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        consumer.subscribe("mqtest1", "TagB");

        consumer.registerMessageListener(new MessageListenerOrderly() {
            AtomicLong consumeTimes = new AtomicLong(0);

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
                                                       ConsumeOrderlyContext context) {
                System.out.printf(
                        Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
                System.out.println("-----" + msgs.get(0).getTopic() + "," + msgs.get(0).getTags()
                        + "," + new String(msgs.get(0).getBody()));
                this.consumeTimes.incrementAndGet();
                System.out.println(this.consumeTimes.get());

                if ((this.consumeTimes.get() % 3) == 0) {
                    context.setSuspendCurrentQueueTimeMillis(3000); // 延迟3秒，验证顺序
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        
        /**
         * OrderedProducer中10个消息，被平均分配到两个队列中（默认一个topic对应4个队列），即单数一个队列，偶数一个队列
         * 在当前消费者中，通过消费结果我们发现单数从小到大，偶数也从小到大，证明了顺序的有效
         */
        
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
