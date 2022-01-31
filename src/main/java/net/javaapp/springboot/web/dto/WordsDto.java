package net.javaapp.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor

public class WordsDto {
    @Id
    @GeneratedValue
    private Integer id;
    private String eng;
    private String rus;
    private String description;
}

