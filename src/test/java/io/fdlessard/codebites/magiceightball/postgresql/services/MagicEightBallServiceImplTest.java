package io.fdlessard.codebites.magiceightball.postgresql.services;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.repositories.MagicEightBallRepository;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MagicEightBallServiceImplTest {

    @Mock
    private MagicEightBallRepository magicEightBallRepository;

    private MagicEightBallService magicEightBallService;

    @BeforeEach
    void beforeEach() {
        magicEightBallService = new MagicEightBallServiceImpl(magicEightBallRepository);
        List<MagicEightBallAnswer> magicEightBallAnswers = Arrays.asList(
                new MagicEightBallAnswer(1, 0,"message1", "color1"),
                new MagicEightBallAnswer(2, 0,"message2", "color2")
        );

        Mockito.when(magicEightBallRepository.findAll()).thenReturn(magicEightBallAnswers);
    }

    @Test
    void shake() {
        assertNotNull(magicEightBallService.shake());
    }

    @Test
    void getAll() {
        assertEquals(2, magicEightBallService.getAll().size());
    }
}