package com.aluracursos.screenmatch.screenmatch_v3.model;

import com.aluracursos.screenmatch.screenmatch_v3.service.GPTQuery;

import java.util.OptionalDouble;

public class Show {
    private String title;
    private Integer totalSeasons;
    private Double rate;
    private Genre genre;
    private String synopsis;
    private String poster;
    private String actors;

    public Show(DataShow dataShow) {
        this.title = dataShow.title();
        this.totalSeasons = dataShow.totalSeasons();
        this.rate = OptionalDouble.of(Double.valueOf(dataShow.rate())).orElse(0);
        this.poster = dataShow.poster();
        this.genre = Genre.fromString(dataShow.genre().split(",")[0].trim());
        this.actors = dataShow.actors();
        this.synopsis = GPTQuery.getTranslation(dataShow.synopsis());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", totalSeasons=" + totalSeasons +
                ", rate=" + rate +
                ", genre=" + genre +
                ", synopsis='" + synopsis + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
