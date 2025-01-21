package utilities.API_Utilities;


import java.util.HashMap;

public class TestData{
    HashMap<String, Object> requestBody;

    public HashMap findingRequestBody() {

        requestBody = new HashMap<>();

        requestBody.put("name", "mouth sore");
        requestBody.put("description", "mouth sore is");
        requestBody.put("finding_category_id", 2);

        return requestBody;
    }

}
