package com.emmanuel.Bibliotheque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExemplaireInconnuException extends RuntimeException {
    public ExemplaireInconnuException(String s) {
        super(s);
      }
}
