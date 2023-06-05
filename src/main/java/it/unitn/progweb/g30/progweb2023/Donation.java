package it.unitn.progweb.g30.progweb2023;

import java.io.Serializable;
import java.sql.Date;

public class Donation implements Serializable {
    private int importo;
    private String data;

    public int getImporto() {
        return importo;
    }

    public String getData() {
        return data;
    }

    public void setImporto(int imp){
        importo = imp;
    }

    public void setData(String data){
        this.data = data;
    }
}
