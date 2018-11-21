package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.repositories.MagicEightBallRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    private MagicEightBallRepository magicEightBallRepository;

    public MagicEightBallServiceImpl(MagicEightBallRepository magicEightBallRepository) {
        this.magicEightBallRepository = magicEightBallRepository;
    }

    public MagicEightBallAnswer shake() {

        log.debug("MagicEightBallServiceImpl.shake()");

        List<MagicEightBallAnswer> magicEightBallAnswers = toList(magicEightBallRepository.findAll());
        int randomResponseIndex = generateRandomNumberBetween(1, magicEightBallAnswers.size());

        log.debug("MagicEightBallServiceImpl.shake() - randomResponseIndex: {}", randomResponseIndex);

        return magicEightBallAnswers.get(randomResponseIndex);
    }

    public List<MagicEightBallAnswer> getAll() {

        log.debug("MagicEightBallServiceImpl.getAll()");

        return toList(magicEightBallRepository.findAll());
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
