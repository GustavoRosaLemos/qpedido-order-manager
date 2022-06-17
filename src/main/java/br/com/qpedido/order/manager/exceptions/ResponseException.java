package br.com.qpedido.order.manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException {
    private int code;
    private String message;
    private String path;
    private LocalDateTime timeStamp;
}
