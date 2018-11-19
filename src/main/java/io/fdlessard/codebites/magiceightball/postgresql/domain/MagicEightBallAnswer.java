package io.fdlessard.codebites.magiceightball.postgresql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagicEightBallAnswer {

    private long id;
    private String message;
    private String color;
}
