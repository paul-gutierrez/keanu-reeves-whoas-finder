package com.cursoAluraLambdas.desafio_lambdasStreams.principal;

import com.cursoAluraLambdas.desafio_lambdasStreams.model.DatosWhoa;
import com.cursoAluraLambdas.desafio_lambdasStreams.model.Whoa;
import com.cursoAluraLambdas.desafio_lambdasStreams.service.ConsumoAPI;
import com.cursoAluraLambdas.desafio_lambdasStreams.service.ConvierteDatos;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_PELICULAS = "https://whoa.onrender.com/whoas/movies";
    private final String URL_BASE = "https://whoa.onrender.com/whoas";
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraMuenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n------------BUSCADOR DE \"WHOAS\" DICHOS POR KEANU REEVES------------");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Ver las películas disponibles");
            System.out.println("2. Obtener un \"whoa\" aleatorio");
            System.out.println("3. Buscar de una película en específico");
            System.out.println("4. Buscar varios \"whoas\"");
            System.out.println("5. Salir");
            System.out.print("->");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Buscar y Mostrar las películas disponibles
                    String json1 = consumoAPI.obtenerDatos(URL_PELICULAS);
                    List<String> peliculas = convierteDatos.obtenerLista(json1);

                    System.out.println("Películas Disponibles:");
                    peliculas.stream().forEach(System.out::println);

                    System.out.print("Ingrese cualquier tecla para continuar: ");
                    scanner.nextLine();
                    break;

                case 2:
                    // Buscar y Mostar un whoa aleatorio
                    String urlWhoaRandom = URL_BASE + "/random";
                    var json2 = consumoAPI.obtenerDatos(urlWhoaRandom);
                    List<DatosWhoa> datosRandomWhoas = convierteDatos.obtenerDatos(json2, new TypeReference<List<DatosWhoa>>() {});

                    // Convirtiendo los datos a una lista del tipo Whoa
                    List<Whoa> randomWhoas = datosRandomWhoas.stream()
                            .map(dato -> new Whoa(dato))
                            .collect(Collectors.toList());

                    // Imprimir los detalles del Whoa
                    System.out.println("Whoa encontrado:");
                    System.out.println(randomWhoas.getFirst());

                    break;

                case 3:
                    // Buscar de una Película específica
                    System.out.print("Ingrese el nombre de la película en donde desee encontrar un whoa: ");
                    String peliculaBuscarWhoa = scanner.nextLine();

                    try {
                        // Codifica el nombre de la película para usarla en la URL
                        String peliculaCodificada = URLEncoder.encode(peliculaBuscarWhoa, "UTF-8");
                        String urlWhoaPeliculaEspecifica = "https://whoa.onrender.com/whoas/random?movie=" + peliculaCodificada;

                        // Llamada a la API
                        ConsumoAPI consumoAPI = new ConsumoAPI();
                        String jsonResponse = consumoAPI.obtenerDatos(urlWhoaPeliculaEspecifica);

                        // Convierte la respuesta JSON en una lista de DatosWhoa
                        List<DatosWhoa> datosWhoas = convierteDatos.obtenerDatos(jsonResponse, new TypeReference<List<DatosWhoa>>() {});

                        // Convirtiendo los datos a una lista del tipo Whoa
                        List<Whoa> whoasPeliculaEspecifica = datosWhoas.stream()
                                .map(dato -> new Whoa(dato))
                                .collect(Collectors.toList());

                        // Imprimir los detalles del Whoa
                        System.out.println("Whoa encontrado:");
                        System.out.println(whoasPeliculaEspecifica.getFirst());

                    } catch (UnsupportedEncodingException e) {
                        System.out.println("Error al codificar el nombre de la película: " + e.getMessage());
                    }

                    break;

                case 4:
                    // Buscar múltiples Whoas con opciones de ordenamiento
                    System.out.print("Ingrese la cantidad de resultados que desea obtener: ");
                    int cantidadResultados = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione el campo por el que desea ordenar los Whoas:");
                    System.out.println("1. Película");
                    System.out.println("2. Fecha de lanzamiento");
                    System.out.println("3. Director");
                    System.out.println("4. Número actual de whoa");
                    System.out.print("->");
                    int campoOrden = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione la dirección de ordenamiento:");
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    System.out.print("->");
                    int direccionOrden = scanner.nextInt();
                    scanner.nextLine();

                    // Mapeo de opciones a parámetros de URL
                    String campoOrdenTexto;
                    switch (campoOrden) {
                        case 1 -> campoOrdenTexto = "movie";
                        case 2 -> campoOrdenTexto = "release_date";
                        case 3 -> campoOrdenTexto = "director";
                        case 4 -> campoOrdenTexto = "number_current_whoa";
                        default -> throw new IllegalArgumentException("Opción de ordenamiento inválida.");
                    }

                    String direccionOrdenTexto = direccionOrden == 1 ? "asc" : "desc";

                    // Construir la URL
                    String urlWhoasOrdenados = String.format(
                            "https://whoa.onrender.com/whoas/random?results=%d&sort=%s&direction=%s",
                            cantidadResultados, campoOrdenTexto, direccionOrdenTexto
                    );

                    // Usar ConsumoAPI para obtener los datos
                    ConsumoAPI consumoAPI = new ConsumoAPI();
                    String jsonWhoas = consumoAPI.obtenerDatos(urlWhoasOrdenados);

                    // Convertir JSON a lista de DatosWhoa y luego a lista de Whoa
                    List<DatosWhoa> datosWhoasOrdenados = convierteDatos.obtenerDatos(jsonWhoas, new TypeReference<List<DatosWhoa>>() {});
                    List<Whoa> whoasOrdenados = datosWhoasOrdenados.stream()
                            .map(Whoa::new)
                            .collect(Collectors.toList());

                    // Imprimir los detalles de los Whoas
                    System.out.println("Whoas encontrados:");
                    whoasOrdenados.forEach(System.out::println);
                    break;

                case 5:
                    continuar = false;
                    System.out.println("¡Hasta el proximo Whoa!");
                    break;
            }
        }
    }
}
