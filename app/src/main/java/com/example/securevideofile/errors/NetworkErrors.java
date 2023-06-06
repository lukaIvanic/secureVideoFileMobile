package com.example.securevideofile.errors;

public enum NetworkErrors {

    INVALID_CAST("Invalid response from API."),
    INVALID_REQUEST_TYPE("Can't figure out request method (GET, POST, ...) for url.");

    private String message;

    NetworkErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException(){
        return new Exception(message);
    }

}
