package com.cursoAluraLambdas.desafio_lambdasStreams.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, TypeReference<T> tipoReferencia);
}
