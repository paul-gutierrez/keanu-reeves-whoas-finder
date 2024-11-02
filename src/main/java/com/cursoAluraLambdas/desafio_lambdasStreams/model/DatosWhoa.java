package com.cursoAluraLambdas.desafio_lambdasStreams.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosWhoa(
        @JsonAlias("movie") String pelicula,
        @JsonAlias("year") LocalDate fechaDeLanzamiento,
        @JsonAlias("director") String director,
        @JsonAlias("character") String personaje,
        @JsonAlias("timestamp") String momentoAparicion,
        @JsonAlias("full_line") String fraseCompleta,
        @JsonAlias("current_whoa_in_movie") Integer whoaActualEnPelicula,
        @JsonAlias("total_whoas_in_movie") Integer whoasTotalesEnPelicula) {
}
