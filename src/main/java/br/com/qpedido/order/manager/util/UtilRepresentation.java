package br.com.qpedido.order.manager.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;

public interface UtilRepresentation {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ResponseSuccess {
        private int code;
        private String message;
        private Object content;
        private String path;
        private LocalDateTime timeStamp;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ResponseException {
        private int code;
        private String message;
        private String path;
        private LocalDateTime timeStamp;
    }
}
