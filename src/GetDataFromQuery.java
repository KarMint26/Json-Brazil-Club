import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetDataFromQuery {
    public ModelAPI ResultData(String q) {
        String fileName = "/home/yohanes/IdeaProjects/Java-JSON-ClubBrazil/src/JSON/brazil_club.json";
        ModelAPI resModel = new ModelAPI();

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

            JsonNode jsonArray = jsonNode.get("clubs");

            for(int i = 0; i < jsonArray.size(); i++) {
                String resName = jsonArray.get(i).get("name").toString();
                String newString = "\"" + q + "\"";
                if(newString.equals((resName))){
                    resModel.setName(jsonArray.get(i).get("name").toString());
                    resModel.setCode(jsonArray.get(i).get("code").toString());
                    resModel.setCountry(jsonArray.get(i).get("country").toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resModel;
    }
}
