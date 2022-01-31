package net.javaapp.springboot.web;

import net.javaapp.springboot.web.dto.WordsDto;
import net.javaapp.springboot.exception.ValidationException;
import net.javaapp.springboot.service.WordsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/words")
@AllArgsConstructor
@Log
@CrossOrigin
public class WordsController
 {

    private final WordsService wordsService;

    @PostMapping("/save")
    public WordsDto saveWords(@RequestBody WordsDto wordsDto) throws ValidationException, javax.xml.bind.ValidationException {
        log.info("Handling SAVE word request: " + wordsDto);
        try {
            return wordsService.saveWord(wordsDto);
        } catch (javax.xml.bind.ValidationException e) {
            e.printStackTrace();
        }
        return wordsService.saveWord(wordsDto);
    }

    @GetMapping("/findAll")
    public List<WordsDto> findAllWords() {
        log.info("Handling find all words request");
        return wordsService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable Integer id) {
        log.info("Handling DELETE word request: " + id);
        wordsService.deleteWord(id);
        return ResponseEntity.ok().build();
    }

     @RequestMapping("/update-word")
     public ResponseEntity<Void> updateWord (@PathVariable Integer id) {
         log.info("Handling UPDATE word request: " + id);
         wordsService.updateWord(id);
         return ResponseEntity.ok().build();
     }
}
