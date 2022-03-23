package uz.pdp.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String name;

    private String author;

    private Long price;

    private Long size;


}
