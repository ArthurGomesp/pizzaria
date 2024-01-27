package com.Gomes.pizzaria.controller.exception;

import java.time.LocalDateTime;

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

    public LocalDateTime getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(LocalDateTime timesStamp) {
        this.timesStamp = timesStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
