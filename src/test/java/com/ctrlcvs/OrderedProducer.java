package com.ctrlcvs;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description 顺序消息生产者
 * @author linb
 * @date 2017年8月28日 上午9:31:07
 */
public class OrderedProducer {

    public static void main(String[] args) throws Exception {
        try {
            // 初始化
            DefaultMQProducer producer = new DefaultMQProducer("OrderedProducerGroupName");
            producer.setNamesrvAddr("192.168.0.25:9876");
            // 启动服务
            producer.start();
            // 定义样例，使得符合相同条件的消息（%值相同）进入相同的队列，被顺序消费
            String[] tags = new String[] { "TagA", "TagB", "TagC", "TagD", "TagE" };
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(new Date());
            for (int i = 0; i < 4; i++) {
                int orderId = i % 2;
                Message msg = new Message("mqtest1", "TagA", "KEY" + i,
                        ("Hello RocketMQ Test " + i + "-" + time).getBytes("UTF-8"));
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    // 在获取到路由信息以后，会根据MessageQueueSelector实现的算法来选择一个队列，同一个OrderId获取到的肯定是同一个队列。
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        // 根据我们的算法，选择一个发送队列
                        // 这里的arg = orderId
                        // 默认情况下，每个topic有4个消息队列，即消息会根据orderId分配到4个队列中的摸个队列
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 0);

                System.out.printf("%s%n", sendResult);
            }
            // 关闭服务
            producer.shutdown();
        } catch (MQClientException | RemotingException | MQBrokerException
                | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
