package com.coolk1ng.rabbitmq.amqp;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coolk1ng
 * @since 2023/3/8 21:19
 */
@Component
@Slf4j
public class ConsumerAckListener implements ChannelAwareMessageListener {
    @Override
//    @RabbitListener(queues = "testQueue")
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            //获取消息
            log.info("message-----{}", new String(message.getBody()));
            //处理逻辑
            log.info("处理完成.....");
            System.out.println(1/0);
            //手动确认
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            //拒绝签收,重回队列
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
