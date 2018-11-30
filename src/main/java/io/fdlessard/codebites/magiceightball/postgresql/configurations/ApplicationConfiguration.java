package io.fdlessard.codebites.magiceightball.postgresql.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


@Configuration
public class ApplicationConfiguration {

    public static final String EXCHANGE_NAME = "appExchange";
    public static final String MAGIC_EIGHT_BALL_ANSWER_QUEUE_NAME = "magicEightBallAnswerQueue";
    public static final String ROUTING_KEY = "messages.key";

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue magicEightBallAnswerQueue() {
        return new Queue(MAGIC_EIGHT_BALL_ANSWER_QUEUE_NAME);
    }

    @Bean
    public Binding declareBindingGeneric() {
        return BindingBuilder.bind(magicEightBallAnswerQueue()).to(appExchange()).with(ROUTING_KEY);
    }

}