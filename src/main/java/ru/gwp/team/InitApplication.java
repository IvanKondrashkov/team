package ru.gwp.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gwp.team.app._example.components.ExampleEntity;
import ru.gwp.team.app._example.services.ExampleService;

@Configuration
@Slf4j
public class InitApplication {

    @Bean
    CommandLineRunner initExampleData(ExampleService exampleService) {
        return args -> {
            log.info("Preloading " +
                    exampleService.create(
                            new ExampleEntity("First title", "First description")));
            log.info("Preloading " +
                    exampleService.create(
                            new ExampleEntity("Second title", "Second description")));
        };
    }

}
