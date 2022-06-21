package br.com.qpedido.order.manager.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class Util {
    public static ResponseEntity<?> responseEntity(String message, Object content, HttpStatus http, String path) {
        return ResponseEntity.status(HttpStatus.OK).body(new UtilRepresentation.ResponseSuccess(http.value(), message, content, path, LocalDateTime.now()));
    }

    public static ResponseEntity<?> responseEntity(String message, Object content, String path) {
        return ResponseEntity.status(HttpStatus.OK).body(new UtilRepresentation.ResponseSuccess(HttpStatus.OK.value(), message, content, path, LocalDateTime.now()));
    }

    public static ResponseEntity<?> responseErrorEntity(Exception e, HttpStatus http, String path) {
        return ResponseEntity.status(http).body(new UtilRepresentation.ResponseException(http.value(),
                e.getMessage(), path, LocalDateTime.now()) {
        });
    }
}
