package com.rp.demo.rest;

public class CustomErrorResponse {

    private int status;

    private String message;

    private long timestamp;


    public CustomErrorResponse(){

    }


    public CustomErrorResponse(int status,String message,long timestamp) {
        this.status = status;
        this.message=message;
        this.timestamp=timestamp;
    }


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
