package net.javaapp.springboot.repository;

import net.javaapp.springboot.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Words, Integer> {
    Words findByEng(String eng);
}
