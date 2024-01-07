import java.util.List;

public class Chatbot {

    private String input;
    private String response;
    private String keywords;

    private List<Response> responses;

    public Chatbot() {
//        responses = Response.responses();
        responses = Response.loadJSON("response.json");

    }

    public String response(String input) {
        String[] splitMessage = input.split("\\s+|[,;?!.-]\\s*");

        for (Response response : responses) {
            System.out.println(response.getInput());
            System.out.println(response.getResponse());
            System.out.println(response.getKeyword());

        }

        return "Sorry, I don't understand.";
    }
}
