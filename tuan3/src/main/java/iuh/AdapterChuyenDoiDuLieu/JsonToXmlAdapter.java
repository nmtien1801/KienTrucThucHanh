package iuh.AdapterChuyenDoiDuLieu;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlAdapter {
    public static String convertJsonToXml(String json) {
        JSONObject jsonObject = new JSONObject(json);
        return XML.toString(jsonObject);
    }
}

