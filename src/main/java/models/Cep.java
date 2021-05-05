package models;

import com.google.gson.annotations.SerializedName;

public class Cep {
    @SerializedName("cep")
    private String cep;

    public Cep(String _cep){
        cep = _cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
