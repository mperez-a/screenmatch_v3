package com.aluracursos.screenmatch.screenmatch_v3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataShow(
        @JsonAlias("Title") String title,
        @JsonAlias("totalSeasons") Integer totalSeasons,
        @JsonAlias("imdbRating") String rate,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Plot") String synopsis,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Actors") String actors) {
}
