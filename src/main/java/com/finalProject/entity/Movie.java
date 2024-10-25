package com.finalProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private double rating;
    @Column(nullable = false)
    private int releaseYear;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String trailerLink;







}
