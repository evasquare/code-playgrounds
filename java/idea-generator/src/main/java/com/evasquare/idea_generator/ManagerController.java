package com.evasquare.idea_generator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.List;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

class GenerateDetails {
    @JsonProperty("status")
    int status;
    @JsonProperty("idea")
    Idea idea;

    public GenerateDetails(int status, Idea idea) {
        this.status = status;
        this.idea = idea;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}


@RestController
public class ManagerController {
    @Autowired
    OpenAiChatModel chatModel;

    @Autowired
    IdeaDaoService ideaDaoService;

    @PostMapping("/ideas")
    public ResponseEntity<GenerateDetails> generate() {
        String content = chatModel.call(
                "Generate one single coding project idea. The answer should never include anythin else.")
                .toString();
        String title = chatModel.call(
                "Generate a title for the following project idea. (The answer should never include anything else):\n"
                        + content)
                .toString();

        String newId = Integer.toString(ideaDaoService.findAll().size() + 1);
        Idea createdIdea = ideaDaoService.save(new Idea(newId, title, content));

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
                .buildAndExpand(createdIdea).toUri();
        return ResponseEntity.created(location)
                .body(new GenerateDetails(HttpStatus.CREATED.value(), createdIdea));
    }


    @GetMapping("/ideas")
    public List<Idea> retrieveAllIdeas() {
        return ideaDaoService.findAll();
    }

    @GetMapping("/ideas/{id}")
    public Idea retrieveIdea(@PathVariable String id) {
        return ideaDaoService.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIdea(@PathVariable String id) {
        ideaDaoService.deleteById(id);
    }
}
