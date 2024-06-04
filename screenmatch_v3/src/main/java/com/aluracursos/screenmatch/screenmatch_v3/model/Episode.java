package com.aluracursos.screenmatch.screenmatch_v3.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double rate;
    private LocalDate releaseDate;

    public Episode(Integer season, EpisodeData episodeData) {
        this.season = season;
        this.title = episodeData.title();
        this.episodeNumber = episodeData.episodeNumber();
        try {
            this.rate = Double.valueOf(episodeData.rate());
        } catch (NumberFormatException exception) {
            this.rate = 0.0;
        }
        try {
            this.releaseDate = LocalDate.parse(episodeData.releasedDate());
        } catch (DateTimeException exception) {
            this.releaseDate = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", rate=" + rate +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
