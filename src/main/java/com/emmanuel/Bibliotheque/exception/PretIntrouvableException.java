package com.emmanuel.Bibliotheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PretIntrouvableException extends RuntimeException {
    public PretIntrouvableException(String s) {
        super(s);
    }
}
