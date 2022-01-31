package net.javaapp.springboot.service;

import net.javaapp.springboot.web.dto.WordsDto;
import net.javaapp.springboot.model.Words;
import org.springframework.stereotype.Component;

@Component
public class WordConverter {

    public Words fromWordDtoToWord(WordsDto wordsDto) {
        Words words = new Words();
        words.setEng(wordsDto.getEng());
        words.setRus(wordsDto.getRus());
        words.setDescription(wordsDto.getDescription());
        return words;
    }

    public WordsDto fromWordToWordDto(Words words) {
        return WordsDto.builder()
                .id(words.getId())
                .description(words.getDescription())
                .rus(words.getRus())
                .eng(words.getEng())
                .build();
    }
}
