package io.fdlessard.codebites.magiceightball.postgresql.controllers;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.postgresql.services.MagicEightBallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<MagicEightBallAnswer> get(@PathVariable("id") long id) {
        log.debug("MagicEightBallController.get({id})", id);
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.getById(id);
        if (magicEightBallAnswer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(magicEightBallAnswer);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<MagicEightBallAnswer> getAll() {
        log.debug("MagicEightBallController.getAll()");
        return magicEightBallService.getAll();
    }

    @PostMapping(value = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody MagicEightBallAnswer magicEightBallAnswer) {
        log.debug("MagicEightBallController.create({})", magicEightBallAnswer);
        magicEightBallService.save(magicEightBallAnswer);
    }
}
