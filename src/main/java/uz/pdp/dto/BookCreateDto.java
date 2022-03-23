package uz.pdp.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    private String name;

    private String author;

    private Long price;

    private Long size;

}
