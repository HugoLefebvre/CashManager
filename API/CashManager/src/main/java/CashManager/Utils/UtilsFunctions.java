package CashManager.Utils;

import java.util.HashMap;
import java.util.Map;

public class UtilsFunctions {

    public static Map<String, String> bodyToMap(String bodyStr) {
        Map<String, String> body = new HashMap<>();
        String[] values = bodyStr.split("&");
        for (String value : values) {
            String[] pair = value.split("=");
            if (pair.length == 2) {
                body.put(pair[0], pair[1]);
            }
        }
        return body;
    }

    public static String getValue(Map<String, String> map, String key) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
