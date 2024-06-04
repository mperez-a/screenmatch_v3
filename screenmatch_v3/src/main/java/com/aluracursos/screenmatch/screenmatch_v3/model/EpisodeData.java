package com.aluracursos.screenmatch.screenmatch_v3.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(
        @JsonAlias("Title") String title,
        @JsonAlias("Episode") Integer episodeNumber,
        @JsonAlias("imdbRating") String rate,
        @JsonAlias("Released") String releasedDate) {
}
