package net.javaapp.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "words")
@Data
@NoArgsConstructor
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String eng;

    @Column
    private String rus;

    @Column
    private String description;

}
