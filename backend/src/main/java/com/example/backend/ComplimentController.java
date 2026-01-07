package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class ComplimentController {

    private final List<String> compliments = List.of(
        "Verily, thou art more pleasant than a warm hearth in winter.",
        "Thy wit is sharper than a fresh-forged sword!",
        "I would gladly share my last wheel of cheese with thee.",
        "Thou lookest dashing enough to marry into royalty immediately.",
        "Hark! Thy presence is more welcome than ale after the harvest.",
        "Thy charm could convince a dragon to give up its hoard.",
        "Thou hast a spirit wilder than a boar in the forest.",
        "Even the court jesters take notes when thou speakest.",
        "Thou art the finest creature to ever walk upon cobblestone.",
        "Forsooth, thou shinest brighter than a polished shield."
    );

    private int lastIndex = -1;
    private final Random random = new Random();

    @GetMapping("/api/compliment")
    public String getCompliment() {
        int newIndex;

        do {
            newIndex = random.nextInt(compliments.size());
        } while (newIndex == lastIndex);

        lastIndex = newIndex;
        return compliments.get(newIndex);
    }
}