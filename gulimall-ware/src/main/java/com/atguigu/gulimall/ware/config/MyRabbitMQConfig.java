package com.atguigu.gulimall.ware.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class MyRabbitMQConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Exchange stockEventExchange() {
        TopicExchange topicExchange = new TopicExchange("stock-event-exchange", true, false);
        return topicExchange;
    }

    // @RabbitListener(queues = "stock.release.stock.queue")
    // public void handle(Message message) {
    // }

    @Bean
    public Queue stockReleaseStockQueue() {
        Queue queue = new Queue("stock.release.stock.queue", true, false, false);
        return queue;
    }

    @Bean
    public Queue stockDelay() {
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "stock-event-exchange");
        arguments.put("x-dead-letter-routing-key", "stock.release");

        arguments.put("x-message-ttl", 120000);
        Queue queue = new Queue("stock.delay.queue", true, false, false, arguments);
        return queue;
    }

    @Bean
    public Binding stockLocked() {
        Binding binding = new Binding("stock.release.stock.queue",
                Binding.DestinationType.QUEUE,
                "stock-event-exchange",
                "stock.release.#",
                null);
        return binding;
    }

    @Bean
    public Binding stockLockedBinding() {
        return new Binding("stock.delay.queue",
                Binding.DestinationType.QUEUE,
                "stock-event-exchange",
                "stock.locked",
                null);
    }
}
