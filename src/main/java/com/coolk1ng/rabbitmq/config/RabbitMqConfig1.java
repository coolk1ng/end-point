package com.coolk1ng.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author coolk1ng
 * @since 2023/3/8 20:42
 */
@Configuration
public class  RabbitMqConfig1 {

    @Bean(name = "firstQueue")
    public Queue returnTestQueue() {
        return new Queue("testQueue", true, false, false);
    }

    //定义交换机
    @Bean(name = "firstExchange")
    public DirectExchange returnTestExchange() {
        return new DirectExchange("testExchange");
    }

    //将队列绑定交换机
    @Bean
    public Binding confirmTestExchangeAndQueue(
            @Qualifier("firstExchange") DirectExchange TestExchange,
            @Qualifier("firstQueue") Queue TestQueue) {
        return BindingBuilder.bind(TestQueue).to(TestExchange).with("testRoutingKey");
    }

    @Bean(name = "secondQueue")
    public Queue testTtlQueue() {
        return new Queue("test_ttl_queue", true, false, false);
    }

    @Bean(name = "secondExchange")
    public Exchange testTtlExchange() {
        return ExchangeBuilder.fanoutExchange("test_ttl_exchange").durable(true).build();
    }

    @Bean
    public Binding ttlTestExchangeAndQueue(@Qualifier("secondExchange") Exchange exchange, @Qualifier("secondQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("ttl_routing_key").noargs();
    }


    /*===============================================*/
    //业务交换机
    public static final String BUSINESS_EXCHANGE = "business.exchange";
    //死信交换机
    public static final String DEAD_LETTER_EXCHANGE = "dead.letter.exchange";
    //常规超时时间
    public static Long QUEUE_EXPIRATION = 20000L;
    //支付超时时间
    public static Long QUEUE_PAID_EXPIRATION = 60000*30L;
    /**订单待支付队列*/
    public static final String UNPAID_QUEUE = "unpaid.queue";
    /**订单待支付死信队列*/
    public static final String UNPAID_DEAD_LETTER_QUEUE = "unpaid.dead.letter.queue";
    /**订单待支付路由键*/
    public static final String UNPAID_ROUTING_KEY = "unpaid.routing.key";
    /**订单待支付死信路由键*/
    public static final String UNPAID_DEAD_LETTER_ROUTING_KEY = "unpaid.dead.letter.routing.key";

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Exchange getBusinessExchange(){
        return ExchangeBuilder.directExchange(BUSINESS_EXCHANGE).durable(true).build();
    }

    @Bean
    public Exchange getDeadLetterExchange(){return ExchangeBuilder.directExchange(DEAD_LETTER_EXCHANGE).durable(true).build();}

    /**订单未支付队列*/
    @Bean
    public Queue getUnpaidQueue(){
        Map<String,Object> args = new HashMap<>();
        //x-dead-letter-exchange 声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        //x-dead-letter-routing-key 声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", UNPAID_DEAD_LETTER_ROUTING_KEY);
        //设置过期时间
        args.put("x-message-ttl", QUEUE_PAID_EXPIRATION);
        return QueueBuilder.durable(UNPAID_QUEUE).withArguments(args).build();
    }

    /**绑定业务交换机和订单未支付队列*/
    @Bean
    public Binding bindUnpaid(){
        return BindingBuilder.bind(getUnpaidQueue()).to(getBusinessExchange()).with(UNPAID_ROUTING_KEY).noargs();
    }

    /**订单待支付死信队列*/
    @Bean
    public Queue getUnpaidDeadLetterQueue(){return new Queue(UNPAID_DEAD_LETTER_QUEUE);}

    /**绑定死信交换机和待支付死信队列*/
    @Bean
    public Binding bingUnpaidDeadLetter(){
        return BindingBuilder.bind(getUnpaidDeadLetterQueue()).to(getDeadLetterExchange()).with(UNPAID_DEAD_LETTER_ROUTING_KEY).noargs();
    }
}
