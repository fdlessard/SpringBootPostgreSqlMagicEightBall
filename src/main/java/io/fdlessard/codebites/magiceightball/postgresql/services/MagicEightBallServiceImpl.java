package io.fdlessard.codebites.magiceightball.postgresql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.repositories.MagicEightBallRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    private MagicEightBallRepository magicEightBallRepository;

    private MessageSender messageSender;

    public MagicEightBallServiceImpl(MagicEightBallRepository magicEightBallRepository, MessageSender messageSender) {
        this.magicEightBallRepository = magicEightBallRepository;
        this.messageSender = messageSender;
    }

    public MagicEightBallAnswer shake() {

        log.debug("MagicEightBallServiceImpl.shake()");

        List<MagicEightBallAnswer> magicEightBallAnswers = toList(magicEightBallRepository.findAll());
        int randomResponseIndex = generateRandomNumberBetween(1, magicEightBallAnswers.size());

        log.debug("MagicEightBallServiceImpl.shake() - randomResponseIndex: {}", randomResponseIndex);

        return magicEightBallAnswers.get(randomResponseIndex);
    }

    @Cacheable(value = "magicEightBallAnswer", key = "#id")
    public MagicEightBallAnswer getById(long id) {
        log.debug("MagicEightBallServiceImpl.getById({id})", id);
        return magicEightBallRepository.findById(id).orElse(null);
    }

    public List<MagicEightBallAnswer> getAll() {

        log.debug("MagicEightBallServiceImpl.getAll()");

        return toList(magicEightBallRepository.findAll());
    }

    public void save(MagicEightBallAnswer magicEightBallAnswers) {
        log.debug("MagicEighBallServiceImpl.create()");
        messageSender.sendMessage(magicEightBallAnswers);
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            return upperBound;
        }
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }
}
