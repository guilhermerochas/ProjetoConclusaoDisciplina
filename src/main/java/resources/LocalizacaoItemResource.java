package resources;

public class LocalizacaoItemResource {
    private String id;
    private String cep;
    private String uf;

    public String getId() {
        return id;
    }

    public LocalizacaoItemResource setId(String id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public LocalizacaoItemResource setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public LocalizacaoItemResource setUf(String uf) {
        this.uf = uf;
        return this;
    }

    @Override
    public String toString() {
        return this.getCep() + " - CEP Localizado: " + this.getUf();
    }
}
