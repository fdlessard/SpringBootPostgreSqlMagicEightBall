package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.postgresql.configurations.ApplicationConfiguration;
import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MagicEightBallAnswer magicEightBallAnswer) {
        log.info("MessageSender.sendMessage");
        rabbitTemplate.convertAndSend(ApplicationConfiguration.EXCHANGE_NAME, ApplicationConfiguration.ROUTING_KEY, magicEightBallAnswer);
    }
}
