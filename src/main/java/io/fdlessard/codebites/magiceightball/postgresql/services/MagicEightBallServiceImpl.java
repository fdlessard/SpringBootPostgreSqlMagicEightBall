package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    public MagicEightBallAnswer shake() {

        log.debug("MagicEightBallServiceImpl.shake()");

        List<MagicEightBallAnswer> magicEightBallAnswers = new ArrayList<>();
        int randomResponseIndex = generateRandomNumberBetween(1, magicEightBallAnswers.size());

        log.debug("MagicEightBallServiceImpl.shake() - randomResponseIndex: {}", randomResponseIndex);

        return magicEightBallAnswers.get(randomResponseIndex);
    }

    public List<MagicEightBallAnswer> getAll() {

        log.debug("MagicEightBallServiceImpl.getAll()");

        return null;
    }


    private static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            return upperBound;
        }
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }

}
