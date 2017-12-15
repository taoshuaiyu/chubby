package com.ctrlcvs.mq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

// 生产者
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup");
        producer.setNamesrvAddr("192.168.0.25:9876");
        producer.start();

        for (int i = 0; i < 4; i++) {
            try {
                Message msg = new Message("test", "modify_user_phone",
                        ("Hello RocketMQ" + i).getBytes("UTF-8"));
                SendResult sendResult=producer.send(msg);
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }
        producer.shutdown();
    }
}