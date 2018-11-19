package io.fdlessard.codebites.magiceightball.postgresql.services;


import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;

import java.util.List;

public interface MagicEightBallService {

    MagicEightBallAnswer shake();
    List<MagicEightBallAnswer> getAll();
}
