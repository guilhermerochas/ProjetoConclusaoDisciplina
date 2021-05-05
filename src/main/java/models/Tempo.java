package models;

import com.google.gson.annotations.SerializedName;

public class Tempo {
    @SerializedName("status")
    private String tempo;
    @SerializedName("temperatura")
    private String temperatura;

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Tempo{" +
                "tempo='" + tempo + '\'' +
                ", temperatura='" + temperatura + '\'' +
                '}';
    }
}
