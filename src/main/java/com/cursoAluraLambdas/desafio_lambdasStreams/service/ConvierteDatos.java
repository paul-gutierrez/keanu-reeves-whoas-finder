package com.cursoAluraLambdas.desafio_lambdasStreams.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper mapper;

    public ConvierteDatos() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    // Convertir JSON a un Objeto
    @Override
    public <T> T obtenerDatos(String json, TypeReference<T> tipoReferencia) {
        try {
            return mapper.readValue(json, tipoReferencia);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Convertir JSON a una lista de strings
    public List<String> obtenerLista(String json) {
        try {
            return mapper.readValue(json, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
