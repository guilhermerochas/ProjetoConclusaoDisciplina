package core;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import models.LocalizacaoResult;
import repository.FirebaseRepositoryMock;
import services.LocalizarService;
import ui.MainPanel;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public class MainCore {
    public static void main(String[] args) throws Exception {
        //FirebaseRepositoryMock mock = new FirebaseRepositoryMock();

        //mock.obterLocalizacoes().forEach(System.out::println);
        System.out.println("Usando modo: " + System.getenv("DEPLOY_MODE") == null ? "Development" : System.getenv("DEPLOY_MODE"));
        //MainPanel.main(args);
    }
}
