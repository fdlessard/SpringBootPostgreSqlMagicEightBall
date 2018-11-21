package io.fdlessard.codebites.magiceightball.postgresql.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table( schema = "my_schema", name = "MAGIC_EIGHT_BALL_ANSWER")
public class MagicEightBallAnswer implements Serializable {

    @Id
    @GeneratedValue(generator = "Seq")
    @SequenceGenerator(
            name = "Seq",
            schema = "my_schema",
            sequenceName = "SEQ_ID",
            allocationSize = 1
    )
    private long id;

    @JsonIgnore
    @Version
    private int version;

    @NotNull(message = "{magiceightball.message}")
    private String message;

    @NotNull(message = "{magiceightball.color}")
    private String color;
}
