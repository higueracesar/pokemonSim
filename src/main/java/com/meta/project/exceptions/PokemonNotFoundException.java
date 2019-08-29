package com.meta.project.exceptions;

import org.springframework.http.HttpStatus;

public class PokemonNotFoundException extends Exception {
    private String message = "Pokemon not found";
    private Integer status = HttpStatus.NOT_FOUND.value();
}
