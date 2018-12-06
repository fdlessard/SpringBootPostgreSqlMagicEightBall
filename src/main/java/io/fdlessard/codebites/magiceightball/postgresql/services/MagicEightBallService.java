package io.fdlessard.codebites.magiceightball.postgresql.services;


import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;

import java.util.List;
import java.util.Optional;

public interface MagicEightBallService {

    MagicEightBallAnswer shake();
    MagicEightBallAnswer getById(long id);
    List<MagicEightBallAnswer> getAll();
    void save(MagicEightBallAnswer magicEightBallAnswer);
}
