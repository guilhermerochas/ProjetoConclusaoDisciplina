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
        StringBuilder builder = new StringBuilder();
        builder.append("Informações do Cep Pesquisado: \n\n");
        builder.append("CEP: " + cep + " \n");
        builder.append("Endereço: " + endereco.fullAddress() +  " \n");
        builder.append("Tempo Atual: " + tempo.getTempo() + ", " + tempo.getTemperatura() + "°C" + " \n");
        builder.append("Latitude e Longitude: " + googleMaps.getLatitude() + ", " + googleMaps.getLongitude());

        return builder.toString();
    }
}
