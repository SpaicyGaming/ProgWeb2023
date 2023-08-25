package it.unitn.progweb.g30.progweb2023;

import java.io.Serializable;

public class ErrorMessageBean implements Serializable {
    private final static int GROUP_ID = 30;
    private String message;

    public ErrorMessageBean() {
        message = "";
    }

    public void setMessage(String msg) {
        message = GROUP_ID + ": " + msg;
    }

    @Override
    public String toString() {
        return message;
    }

}
