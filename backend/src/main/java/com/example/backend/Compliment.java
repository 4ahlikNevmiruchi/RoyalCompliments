package com.example.backend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "compliments")
public class Compliment {
    @Id
    private String id;
    private String text;
    private String author;

    public Compliment() {}

    public Compliment(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getId() { return id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}