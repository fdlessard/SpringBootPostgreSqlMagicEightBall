package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.basic.MagicEightBallBasicApplication;
import io.fdlessard.codebites.magiceightball.basic.domain.MagicEightBallAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
class MagicEightBallServiceImplIt {

    @Autowired
    private MagicEightBallService magicEightBallService;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void shake() {

        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.shake();
        assertNotNull(magicEightBallAnswer);
        assertNotNull(magicEightBallAnswer.getId());
        assertNotNull(magicEightBallAnswer.getMessage());
        assertNotNull(magicEightBallAnswer.getColor());
    }

    @Test
    void getAll() {
        List<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();
        assertNotNull(magicEightBallAnswers);
        assertEquals(20, magicEightBallAnswers.size());
    }
}