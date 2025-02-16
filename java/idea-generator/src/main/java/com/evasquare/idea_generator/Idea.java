package com.evasquare.idea_generator;

import javax.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Idea {
    @Id
    private String id;

    @Size(min = 1)
    private String title;
    @Size(min = 1)
    private String content;

    public Idea() {}

    public Idea(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Idea [title=" + title + ", content=" + content + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
