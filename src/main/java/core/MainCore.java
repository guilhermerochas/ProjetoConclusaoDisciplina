package core;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import models.LocalizacaoResult;
import services.LocalizarService;
import ui.MainPanel;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public class MainCore {
    public static void main(String[] args) {

        //Example for loading ENV variables
        /*
        Dotenv dotenv = Dotenv.configure().filename("dev.env").load();
        System.out.println(dotenv.get("VAR"));
        */

        MainPanel.main(args);
    }
}
