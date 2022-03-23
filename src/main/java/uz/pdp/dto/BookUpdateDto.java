package uz.pdp.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookUpdateDto {

    private Long id;
    private String name;

    private String author;

    private Long price;

    private Long size;



}
