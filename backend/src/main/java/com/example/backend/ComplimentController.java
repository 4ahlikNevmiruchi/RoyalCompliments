package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class ComplimentController {

    @Autowired
    private ComplimentRepository repository;

    @GetMapping("/api/compliment")
    public Compliment getCompliment() {
        List<Compliment> all = repository.findAll();

        if (all.isEmpty()) {
            return new Compliment("The archives are empty!", "System");
        }

        return all.get(new Random().nextInt(all.size()));
    }

    @PostMapping("/api/compliment")
    public Compliment addCompliment(@RequestBody String text) {
        String cleanText = text.replaceAll("^\"|\"$", "");
        return repository.save(new Compliment(cleanText, "Anonymous"));
    }

    @DeleteMapping("/api/compliment/{id}")
    public void deleteCompliment(@PathVariable String id) {
        repository.deleteById(id);
    }
}