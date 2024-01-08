import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {

    private List<String> input;
    private String response;
    private List<String> keyword;

    private ResponseData(){}

    public List<String> getInput() { return input; }
    public String getResponse() { return response; }
    public List<String> getKeyword() { return keyword; }

    public static List<ResponseData> loadJSON(String filePath) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File(filePath);
            TypeReference<ArrayList<ResponseData>> typeReference = new TypeReference<>() {};

            // mapping json and java
            List<ResponseData> loadData = mapper.readValue(file, typeReference);

            return loadData;

        } catch (IOException e) {
            e.printStackTrace();

            // empty list
            return new ArrayList<>();
        }
    }
}