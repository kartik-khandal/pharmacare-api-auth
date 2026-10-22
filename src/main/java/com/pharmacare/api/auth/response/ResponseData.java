package com.pharmacare.api.auth.response;

/** Generic envelope for successful endpoints, keeping status, payload, and message together. */
public class ResponseData<T> {
    private boolean success;
    private T data;
    private String message;

    public ResponseData() {
    }

    public ResponseData(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
