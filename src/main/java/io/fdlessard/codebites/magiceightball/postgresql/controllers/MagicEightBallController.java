package io.fdlessard.codebites.magiceightball.postgresql.controllers;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.services.MagicEightBallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/magiceightball", produces = "application/json")
@Slf4j
public class MagicEightBallController {

    public static final String IS_ALIVE = "MagicEightBallController is alive";

    private MagicEightBallService magicEightBallService;

    public MagicEightBallController(MagicEightBallService magicEightBallService) {
        this.magicEightBallService = magicEightBallService;
    }

    @GetMapping(value = "/isAlive")
    public String isAlive() {
        log.debug("MagicEightBallController.isAlive()");
        return IS_ALIVE;
    }

    @GetMapping(value = "/shake")
    @ResponseBody
    public MagicEightBallAnswer shake() {
        log.debug("MagicEightBallController.shake()");
        return magicEightBallService.shake();
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<MagicEightBallAnswer> getAll() {
        log.debug("MagicEightBallController.getAll()");
        return magicEightBallService.getAll();
    }
}
