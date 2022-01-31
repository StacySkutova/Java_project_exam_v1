package net.javaapp.springboot.service;

import net.javaapp.springboot.web.dto.WordsDto;
import net.javaapp.springboot.exception.ValidationException;

import java.util.List;

public interface WordsService {

    WordsDto saveWord(WordsDto wordsDto) throws ValidationException, javax.xml.bind.ValidationException;

    void deleteWord(Integer wordId);

    void updateWord(Integer wordId);

    List<WordsDto> findAll();
}
