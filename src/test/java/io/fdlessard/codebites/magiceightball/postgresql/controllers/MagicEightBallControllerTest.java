package io.fdlessard.codebites.magiceightball.postgresql.controllers;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.services.MagicEightBallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MagicEightBallControllerTest {

    @Mock
    private MagicEightBallService magicEightBallService;

    private MagicEightBallController magicEightBallController;

    @BeforeEach
    void beforeEach() {
        magicEightBallController = new MagicEightBallController(magicEightBallService);
    }

    @Test
    void isAlive() {
        assertEquals(MagicEightBallController.IS_ALIVE, magicEightBallController.isAlive());
    }

    @Test
    void shake() {

        MagicEightBallAnswer magicEightBallAnswer = new MagicEightBallAnswer(Long.valueOf(0), 0,"message", "color");
        Mockito.when(magicEightBallService.shake()).thenReturn(magicEightBallAnswer);
        assertEquals(magicEightBallAnswer, magicEightBallController.shake());
    }

    @Test
    void getAll() {

        List<MagicEightBallAnswer> magicEightBallAnswers = Arrays.asList(
                new MagicEightBallAnswer(Long.valueOf(1), 0,"message1", "color1"),
                new MagicEightBallAnswer(Long.valueOf(2), 0,"message2", "color2")
        );

        Mockito.when(magicEightBallService.getAll()).thenReturn(magicEightBallAnswers);

        List<MagicEightBallAnswer> mebas = magicEightBallController.getAll();
        assertEquals(2, mebas.size());
        assertEquals(new MagicEightBallAnswer(Long.valueOf(1), 0,"message1", "color1"), mebas.get(0));
        assertEquals(new MagicEightBallAnswer(Long.valueOf(2), 0, "message2", "color2"), mebas.get(1));
    }
}