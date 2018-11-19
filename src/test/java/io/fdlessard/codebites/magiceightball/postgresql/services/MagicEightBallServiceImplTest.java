package io.fdlessard.codebites.magiceightball.postgresql.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MagicEightBallServiceImplTest {

    private MagicEightBallService magicEightBallService;

    @BeforeEach
    void beforeEach() {
        magicEightBallService = new MagicEightBallServiceImpl();
    }

    @Test
    void shake() {
        assertNotNull(magicEightBallService.shake());
    }

    @Test
    void getAll() {
        assertEquals(20, magicEightBallService.getAll().size());
    }
}