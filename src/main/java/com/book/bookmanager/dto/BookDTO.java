package com.book.bookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String titulo;

    @Size(max = 255)
    private String urlFoto;

    @NotNull
    private LocalDate dtPublicacao;

    private String descricao;

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "ISBN format must be a valid format")
    private String isbn;

    @NotNull
    private Integer pag;

    @NotNull
    private Integer cap;

    @NotBlank
    @Size(max = 200)
    private String nomePublicador;

    @Valid
    @NotNull
    private AuthorDTO autor;
}
