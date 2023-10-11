import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        System.out.println("Signature: "+ getHmacSHA256Signature("ad5f60d4-bbb8-4d42-9d53-010320231529", "cyQh2QDReX5ukdou4gofjZ8cDZq5qS", "wdrIGmRrRymF7vanPk4RCQOojGRhh3"));

    }

    static String getHmacSHA256Signature(String nonce, String shopId, String shopKey) throws NoSuchAlgorithmException, InvalidKeyException {

        Mac hmacSha256 = Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKeySpec = new SecretKeySpec(shopKey.getBytes(), "HmacSHA256");
        hmacSha256.init(secretKeySpec);

        String plainString = nonce + "|" + shopId + "|" + shopKey;

        return Hex.encodeHexString(hmacSha256.doFinal(plainString.getBytes()));
    }
}
