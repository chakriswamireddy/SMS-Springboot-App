package com.example.surgeryList.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
           Student mariam =  new Student("mariam","mar@co.in", LocalDate.of(1999,Month.NOVEMBER,14) );
            Student alex =  new Student("alex","alex@co.in", LocalDate.of(2001, Month.JANUARY,12) );

            repository.saveAll(List.of(mariam,alex));

        };


    }
}
