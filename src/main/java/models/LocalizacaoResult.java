package models;

import com.google.gson.annotations.SerializedName;

public class LocalizacaoResult {
    @SerializedName("CEP")
    private String cep;
    @SerializedName("Endereco")
    private Endereco endereco;
    @SerializedName("tempo")
    private Tempo tempo;
    @SerializedName("googleMaps")
    private GoogleMaps googleMaps;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public GoogleMaps getGoogleMaps() {
        return googleMaps;
    }

    public void setGoogleMaps(GoogleMaps googleMaps) {
        this.googleMaps = googleMaps;
    }

    @Override
    public String toString() {
        return "LocalizacaoResult{" +
                "cep='" + cep + '\'' +
                ", endereco=" + endereco +
                ", tempo=" + tempo +
                ", googleMaps=" + googleMaps +
                '}';
    }
}
