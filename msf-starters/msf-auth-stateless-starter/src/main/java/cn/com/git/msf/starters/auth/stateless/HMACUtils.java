package cn.com.git.msf.starters.auth.stateless;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;
import java.util.Map;

/**
 * Created by serj on 2016/2/22.
 */
public class HMACUtils {
    public static String digest(String key, String content) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] secretByte = key.getBytes("utf-8");
            byte[] dataBytes = content.getBytes("utf-8");

            SecretKey secret = new SecretKeySpec(secretByte, "HMACSHA256");
            mac.init(secret);

            byte[] doFinal = mac.doFinal(dataBytes);
            byte[] hexB = new Hex().encode(doFinal);
            return new String(hexB, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String digest(String key, Map<String, String[]> map) {
        StringBuilder s = new StringBuilder();
        for (Object values : map.values()) {
            if (values instanceof String[]) {
                for (String value : (String[]) values) {
                    s.append(value);
                }
            } else if (values instanceof List) {
                for (String value : (List<String>) values) {
                    s.append(value);
                }
            } else {
                s.append(values);
            }
        }
        return digest(key, s.toString());
    }

    public static void main(String[] args) {
        try {
            String sign = HMACUtils.digest("1234", "aaa");
            System.out.println(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
