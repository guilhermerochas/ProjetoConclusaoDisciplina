package core;

import repository.FirebaseRepository;
import resources.LocalizacaoResource;

import java.util.Optional;


public class MainCore {
    public static void main(String[] args) throws Exception {
        new FirebaseRepository().criarLocalizacao(new LocalizacaoResource()
                .setId("178jaçp")
                .setLocalidade("Santos")
                .setCep("11040010")
                .setLatitude("-23.9736663")
                .setLongitude("-46.3105719")
                .setTempo("chovendo")
                .setUf("SP")
                .setImageUrl("./imgs/mock/imagem.jpg"));
    }
}
