import org.json.*;

public class json_ex {
    public static void main(String[] args) {
        // Creating a JSON object
        JSONObject json = new JSONObject();
        json.put("name", "John");
        json.put("age", 25);

        // Printing JSON
        System.out.println("JSON: " + json.toString());
    }
}
