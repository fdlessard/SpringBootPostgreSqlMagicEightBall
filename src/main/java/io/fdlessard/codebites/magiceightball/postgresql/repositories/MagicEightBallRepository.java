package io.fdlessard.codebites.magiceightball.postgresql.repositories;

import io.fdlessard.codebites.magiceightball.postgresql.domain.MagicEightBallAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicEightBallRepository extends CrudRepository<MagicEightBallAnswer, Long> {

}
