package com.aluracursos.screenmatch.screenmatch_v3.model;

import com.aluracursos.screenmatch.screenmatch_v3.service.GPTQuery;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;

@Entity // This annotation is used to indicate that the class is an entity. This annotation is applied to the entity class.
@Table(name = "shows") // This annotation is used to specify the table name that the entity is going to map to.

public class Show {
    @Id // This annotation is used to specify the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to specify how the primary key should be generated.
    private long id;
    @Column(unique = true) // This annotation is used to specify that a unique constraint is to be included on the column.
    private String title;
    private Integer totalSeasons;
    private Double rate;
    @Enumerated(EnumType.STRING) // This annotation is used to specify the mapping of an enum type.
    private Genre genre;
    private String synopsis;
    private String poster;
    private String actors;
    @Transient // This annotation is used to indicate that the property or field is not persistent.
    private List<Episode> episodes;

    public Show() {
    }

    public Show(DataShow dataShow) {
        this.title = dataShow.title();
        this.totalSeasons = dataShow.totalSeasons();
        this.rate = OptionalDouble.of(Double.valueOf(dataShow.rate())).orElse(0);
        this.poster = dataShow.poster();
        this.genre = Genre.fromString(dataShow.genre().split(",")[0].trim());
        this.actors = dataShow.actors();
        this.synopsis = dataShow.synopsis();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
