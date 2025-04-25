package iuh.AdapterChuyenDoiDuLieu;

public class JsonDataImpl implements JsonData {
    private String json;

    public JsonDataImpl(String json) {
        this.json = json;
    }

    @Override
    public String getJson() {
        return json;
    }
}
