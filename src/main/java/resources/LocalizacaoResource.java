package resources;

public class LocalizacaoResource {
    private String id;
    private String cep;
    private String localidade;
    private String uf;
    private String longitude;
    private String latitude;
    private String tempo;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public LocalizacaoResource setId(String id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public LocalizacaoResource setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getLocalidade() {
        return localidade;
    }

    public LocalizacaoResource setLocalidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public LocalizacaoResource setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public LocalizacaoResource setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public LocalizacaoResource setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getTempo() {
        return tempo;
    }

    public LocalizacaoResource setTempo(String tempo) {
        this.tempo = tempo;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalizacaoResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
