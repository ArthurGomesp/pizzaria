package com.Gomes.pizzaria.controller.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class StandardError {
    private LocalDateTime timesStamp;
    private Integer status;
    private String errorMessage;
    private String path;

    public StandardError(LocalDateTime timesStamp, Integer status, String errorMessage, String path) {
        this.timesStamp = timesStamp;
        this.status = status;
        this.errorMessage = errorMessage;
        this.path = path;
    }

}
