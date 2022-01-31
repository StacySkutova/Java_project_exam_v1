package net.javaapp.springboot.service;

import net.javaapp.springboot.web.dto.WordsDto;
import net.javaapp.springboot.model.Words;
import net.javaapp.springboot.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultWordsService implements WordsService {

    private final WordRepository wordsRepository;
    private final WordConverter wordsConverter;

    @Override
    public WordsDto saveWord(WordsDto wordsDto) throws ValidationException {
        validateWordDto(wordsDto);
        Words savedWord = wordsRepository.save(wordsConverter.fromWordDtoToWord(wordsDto));
        return wordsConverter.fromWordToWordDto(savedWord);
    }

    private void validateWordDto(WordsDto wordsDto) throws ValidationException {
        if (isNull(wordsDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(wordsDto.getEng()) || wordsDto.getEng().isEmpty()) {
            throw new ValidationException("No any English word to save");
        }
        if (isNull(wordsDto.getRus()) || wordsDto.getRus().isEmpty()) {
            throw new ValidationException("No translation provided");
        }
    }

    @Override
    public void deleteWord(Integer userId) {
        wordsRepository.deleteById(userId);
    }

    @Override
    public void updateWord(Integer userId) {
        wordsRepository.findById(userId);
    }

    @Override
    public List<WordsDto> findAll() {
        return wordsRepository.findAll()
                .stream()
                .map(wordsConverter::fromWordToWordDto)
                .collect(Collectors.toList());
    }
}