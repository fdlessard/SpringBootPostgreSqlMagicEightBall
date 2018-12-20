package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.postgresql.SpringBootPostgreSqlMagicEightBallApplication;
import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootPostgreSqlMagicEightBallApplication.class)
@ActiveProfiles("integration")
class MagicEightBallServiceImplIt {

    @Autowired
    private MagicEightBallService magicEightBallService;

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
    }

    @Test
    void getById() {
        MagicEightBallAnswer magicEightBallAnswers = magicEightBallService.getById(1);
        assertNotNull(magicEightBallAnswers);
    }

    @Test
    public void save() {

        List<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();
        assertNotNull(magicEightBallAnswers);
        int initialSize = magicEightBallAnswers.size();
        magicEightBallService.save(new MagicEightBallAnswer(null, 0, "message1", "color1"));
        magicEightBallAnswers = magicEightBallService.getAll();
        assertNotNull(magicEightBallAnswers);
    }
}