import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private List<String> input;
    private String response;
    private List<String> keyword;

    private Response(){}
    /*private Response(List<String> input, String response, List<String> keywords) {
        this.input = input;
        this.response = response;
        this.keywords = keywords;
    }*/

    public List<String> getInput() { return input; }

    public String getResponse() { return response; }

    public List<String> getKeyword() { return keyword; }

    public static List<Response> loadJSON(String filePath) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File(filePath);
            TypeReference<ArrayList<Response>> typeReference = new TypeReference<>() {};

            List<Response> loadedData = mapper.readValue(file, typeReference);

            return loadedData;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /*private List<Response> responses() {
        List<Response> responses = new ArrayList<>(List.of(
                new Response(List.of("hi", "hello", "hey"), "Hello! How can I help you?", List.of("")),

                new Response(List.of(""), "", List.of(""));
                *//*
                new Response(List.of(""), "", List.of(""))
                *//*
        ));
    }*/
}