import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "/home/yohanes/IdeaProjects/Java-JSON-ClubBrazil/src/JSON/brazil_club.json";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            String jsonString = stringBuilder.toString();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            JsonNode jsonArray = jsonNode.get("clubs"); // Jadi Ini Menggunakan Array Key

            ArrayList<ModelAPI> responseModels = new ArrayList<>();
            for(int i = 0; i < jsonArray.size(); i++) {
                ModelAPI resModel = new ModelAPI();
                JsonNode myJSONObject = jsonArray.get(i);
                resModel.setName(String.valueOf(myJSONObject.get("name")));
                resModel.setCode(String.valueOf(myJSONObject.get("code")));
                resModel.setCountry(String.valueOf(myJSONObject.get("country")));
                responseModels.add(resModel);
            }

            System.out.println("\nResponse are : ");
            for (ModelAPI responseModel : responseModels) {
                System.out.println("\nNAME : " + responseModel.getName());
                System.out.println("CODE : " + responseModel.getCode());
                System.out.println("COUNTRY : " + responseModel.getCountry());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
