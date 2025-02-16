package com.evasquare.idea_generator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaDaoService extends JpaRepository<Idea, String> {

}
