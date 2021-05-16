package core;

import repository.FirebaseRepository;
import resources.LocalizacaoResource;
import ui.MainPanel;

import java.util.Optional;


public class MainCore {
    public static void main(String[] args) throws Exception {
        new MainPanel().main(args);
    }
}
