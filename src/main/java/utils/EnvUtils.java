package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Optional;

public class EnvUtils {
    private static final String envState = "dev.env";

    public static Optional<String> getEnvVariable(String key) {
        return Optional.ofNullable(Dotenv.configure().filename(envState).load().get(key));
    }
}
