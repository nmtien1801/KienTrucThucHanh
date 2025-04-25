package iuh.AdapterChuyenDoiDuLieu;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJsonAdapter implements JsonData {
    private XmlData xmlData;

    public XmlToJsonAdapter(XmlData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String getJson() {
        String xml = xmlData.getXml();
        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(4); // Format đẹp với 4 khoảng trắng
    }
}

