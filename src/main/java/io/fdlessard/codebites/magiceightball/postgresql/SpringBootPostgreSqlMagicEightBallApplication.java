package io.fdlessard.codebites.magiceightball.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootPostgreSqlMagicEightBallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPostgreSqlMagicEightBallApplication.class, args);
    }
}
