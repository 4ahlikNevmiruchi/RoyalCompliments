package com.example.backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ComplimentRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DatabaseSeeder(ComplimentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("Archives empty. Loading wisdom from JSON file...");

            InputStream inputStream = TypeReference.class.getResourceAsStream("/quotes.json");

            List<Compliment> quotes = objectMapper.readValue(inputStream, new TypeReference<List<Compliment>>(){});

            repository.saveAll(quotes);

            System.out.println("Seeding complete! " + quotes.size() + " Historical Quotes added.");
        }
    }
}