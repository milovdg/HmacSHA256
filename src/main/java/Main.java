import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        String nonce = "ad5f60d4-bbb8-4d42-9d53-010320231529";
        String shopId = "cyQh2QDReX5ukdou4gofjZ8cDZq5qS";
        String shopKey = "wdrIGmRrRymF7vanPk4RCQOojGRhh3";
        String plainString = nonce + "|" + shopId + "|" + shopKey;

        Mac hmacSha256 = Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKeySpec = new SecretKeySpec(shopKey.getBytes(), "HmacSHA256");
        hmacSha256.init(secretKeySpec);

        String signature = Hex.encodeHexString(hmacSha256.doFinal(plainString.getBytes()));

        System.out.println("Signature: "+ signature);

    }
}
