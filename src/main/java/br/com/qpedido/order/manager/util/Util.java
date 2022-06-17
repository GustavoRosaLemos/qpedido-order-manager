package br.com.qpedido.order.manager.util;

import br.com.qpedido.order.manager.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class Util {
    public static ResponseEntity<?> responseEntity(Exception e, HttpStatus http, String path) {
        return ResponseEntity.status(http).body(new ResponseException(http.value(),
                e.getMessage(), path, LocalDateTime.now()));
    }
}
