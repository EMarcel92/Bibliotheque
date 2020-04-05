package com.emmanuel.Bibliotheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PretDejaProlongeException extends RuntimeException {
    public PretDejaProlongeException(String s) {
        super(s);
    }
}
