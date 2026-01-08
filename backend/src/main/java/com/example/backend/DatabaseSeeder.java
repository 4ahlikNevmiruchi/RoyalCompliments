package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ComplimentRepository repository;

    public DatabaseSeeder(ComplimentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("Archives empty. Inscribing wisdom of the ages...");

            List<Compliment> quotes = List.of(
                new Compliment("The die is cast.", "Julius Caesar"),
                new Compliment("I am the state.", "Louis XIV"),
                new Compliment("To defeat the enemy, you must become the enemy.", "Sun Tzu"),
                new Compliment("God is not on the side of the big battalions, but on the side of the best shots.", "Voltaire"),
                new Compliment("A prince must be a fox to know the traps and a lion to frighten the wolves.", "Niccolò Machiavelli"),
                new Compliment("Victorious warriors win first and then go to war, while defeated warriors go to war first and then seek to win.", "Sun Tzu"),
                new Compliment("It is better to be feared than loved, if you cannot be both.", "Niccolò Machiavelli"),
                new Compliment("History is a set of lies agreed upon.", "Napoleon Bonaparte"),
                new Compliment("An army marches on its stomach.", "Napoleon Bonaparte"),
                new Compliment("There is no place for the weak in this world.", "Otto von Bismarck")
            );

            repository.saveAll(quotes);
            System.out.println("Seeding complete! 10 Historical Quotes added.");
        }
    }
}