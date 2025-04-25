package iuh.AdapterChuyenDoiDuLieu;

public class XmlDataImpl implements XmlData {
    private String xml;

    public XmlDataImpl(String xml) {
        this.xml = xml;
    }

    @Override
    public String getXml() {
        return xml;
    }
}

