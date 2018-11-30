package io.fdlessard.codebites.magiceightball.postgresql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.codebites.magiceightball.postgresql.configurations.ApplicationConfiguration;
import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.repositories.MagicEightBallRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class MessageListener {

    private MagicEightBallRepository magicEightBallRepository;

    public MessageListener(MagicEightBallRepository magicEightBallRepository) {
        this.magicEightBallRepository = magicEightBallRepository;
    }

    @RabbitListener(queues = ApplicationConfiguration.MAGIC_EIGHT_BALL_ANSWER_QUEUE_NAME)
    public void receiveMessage(Message message) throws IOException  {

        log.info("Received message as specific class: {}", message.toString());

        ObjectMapper mapper = new ObjectMapper();
        MagicEightBallAnswer magicEightBallAnswer = mapper.readValue(message.getBody(), MagicEightBallAnswer.class);

        magicEightBallRepository.save(magicEightBallAnswer);
    }
}
