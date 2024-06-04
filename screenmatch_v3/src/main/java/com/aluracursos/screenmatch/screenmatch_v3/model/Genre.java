package com.aluracursos.screenmatch.screenmatch_v3.model;

public enum Genre {
    ACTION("Action"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime");

    private String categoryOmbd;

    Genre(String categoryOmbd) {
        this.categoryOmbd = categoryOmbd;
    }

    public static Genre fromString(String text) {
        for (Genre genre : Genre.values()) {
            if (genre.categoryOmbd.equalsIgnoreCase(text)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Non genre was found: " + text);
    }
}
