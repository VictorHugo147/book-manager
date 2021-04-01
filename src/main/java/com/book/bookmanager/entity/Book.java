package com.book.bookmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column
    private String urlFoto;

    @Column(nullable = false)
    private LocalDate dtPublicacao;

    @Column
    private String descricao;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer pag;

    @Column(nullable = false)
    private Integer cap;

    @Column(name = "nome_publicador", nullable = false, unique = true)
    private String nomePublicador;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "autor_id")
    private Author autor;

}
