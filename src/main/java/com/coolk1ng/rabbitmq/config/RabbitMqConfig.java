package com.coolk1ng.rabbitmq.config;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * rabbitmq配置
 *
 * @author coolk1ng
 * @since 2023/1/15 03:49
 */
@Configuration
public class RabbitMqConfig
{

    @Bean(name = "firstConnectionFactory")
    public ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.host}") String host,
                                               @Value("${spring.rabbitmq.port}") Integer port,
                                               @Value("${spring.rabbitmq.username}") String username,
                                               @Value("${spring.rabbitmq.password}") String password,
                                               @Value("${spring.rabbitmq.virtual-host}") String virtualHost)
    {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        cachingConnectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.NONE);
        cachingConnectionFactory.setPublisherReturns(true);
        return cachingConnectionFactory;
    }

    @Bean(name = "firstRabbitTemplate")
    public RabbitTemplate rabbitTemplate (@Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    @Bean(name = "firstContainerFactory")
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                                                         @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory)
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMaxConcurrentConsumers(5);
        factory.setConcurrentConsumers(1);
        factory.setPrefetchCount(1);
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean(name = "firstQueue")
    public String runFirstQueue(@Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory)
    {
        System.out.println("first queue");
        Channel channel;
        try (Connection connection = connectionFactory.createConnection()) {
            channel = connection.createChannel(false);

            channel.exchangeDeclare("test_exchange", "direct", true, false, null);
            channel.queueDeclare("test_queue", true, false, false, null);
            channel.queueBind("test_queue", "test_exchange", "test_routingKey");

            channel.queueDeclare("hello_queue", true, false, false, null);
            channel.queueBind("hello_queue", "test_exchange", "hello_routingKey");

            //channel.queueDeclare("test",true, false, false, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
