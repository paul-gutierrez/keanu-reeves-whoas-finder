package com.cursoAluraLambdas.desafio_lambdasStreams.model;

import java.time.LocalDate;

public class Whoa {
    private String pelicula;
    private LocalDate fechaDeLanzamiento;
    private String director;
    private String personaje;
    private String momentoAparicion;
    private String fraseCompleta;
    private Integer whoaActualEnPelicula;
    private Integer whoasTotalesEnPelicula;

    public Whoa(DatosWhoa dato) {
        this.pelicula = dato.pelicula();
        this.fechaDeLanzamiento = dato.fechaDeLanzamiento();
        this.director = dato.director();
        this.personaje = dato.personaje();
        this.momentoAparicion = dato.momentoAparicion();
        this.fraseCompleta = dato.fraseCompleta();
        this.whoaActualEnPelicula = dato.whoaActualEnPelicula();
        this.whoasTotalesEnPelicula = dato.whoasTotalesEnPelicula();
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getMomentoAparicion() {
        return momentoAparicion;
    }

    public void setMomentoAparicion(String momentoAparicion) {
        this.momentoAparicion = momentoAparicion;
    }

    public String getFraseCompleta() {
        return fraseCompleta;
    }

    public void setFraseCompleta(String fraseCompleta) {
        this.fraseCompleta = fraseCompleta;
    }

    public Integer getWhoaActualEnPelicula() {
        return whoaActualEnPelicula;
    }

    public void setWhoaActualEnPelicula(Integer whoaActualEnPelicula) {
        this.whoaActualEnPelicula = whoaActualEnPelicula;
    }

    public Integer getWhoasTotalesEnPelicula() {
        return whoasTotalesEnPelicula;
    }

    public void setWhoasTotalesEnPelicula(Integer whoasTotalesEnPelicula) {
        this.whoasTotalesEnPelicula = whoasTotalesEnPelicula;
    }

    @Override
    public String toString() {
        return "Whoa{" +
                "pelicula='" + pelicula + '\'' +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", director='" + director + '\'' +
                ", personaje='" + personaje + '\'' +
                ", momentoAparicion='" + momentoAparicion + '\'' +
                ", fraseCompleta='" + fraseCompleta + '\'' +
                ", whoaActualEnPelicula=" + whoaActualEnPelicula +
                ", whoasTotalesEnPelicula=" + whoasTotalesEnPelicula +
                '}';
    }
}
