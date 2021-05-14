package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class OSUtils {
    private static final String envState = System.getenv("DEPLOY_MODE") == null ? "dev.env" : ".env";

    public static Optional<String> getEnvVariable(String key) {
        return Optional.ofNullable(Dotenv.configure().filename(envState).load().get(key));
    }

    public static Stream<String> getFilesFromDir(String dirName) throws IOException {
        Stream<Path> walk = Files.walk(Path.of(dirName));
        return walk.filter(Files::isRegularFile).map(Path::toString);
    }

    public static String getOsType() {
        return System.getProperty("os.name");
    }
}
