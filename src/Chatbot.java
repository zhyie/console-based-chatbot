import java.util.List;
import java.util.Random;

public class Chatbot {

    private final List<ResponseData> responseData;

    public Chatbot() {
        responseData = ResponseData.loadJSON("response.json");
    }

    public String response(String userInput) {

        // splitting user message
        String[] splitMessage = userInput.split("\\s+|[,;?!.-]\\s*");

        for (ResponseData responses : responseData) {

            List<String> keyword = responses.getKeyword();
            List<String> input = responses.getInput();
            String response = responses.getResponse();

            int keywordCount = 0;

            for (String word : splitMessage) {

                // does keyword be seen in user input?
                if (keyword.contains(word)) {
                    keywordCount++;
                }
            }


            // proceed here if they have the keywords
            if (keywordCount > 1) {
                for (String word : splitMessage) {

                    // do they have the inputs?
                    if (input.contains(word)) {
                        return response;
                    }
                }
            }

            else {
                // is it greetings/ xclusive for greetings
                String greetings = isGreeting(userInput);
                if (greetings != null) {
                    return greetings;
                }
            }
        }

        // nah they dont
        return otherResponse();
    }

    private String otherResponse() {
        List<String> randomResponses = List.of(
                "I don't understand.",
                "I'm not sure what you're talking about.",
                "Can you provide more details?"
        );

        Random random = new Random();
        int randomResponse = random.nextInt(randomResponses.size());

        return randomResponses.get(randomResponse);
    }

    private String isGreeting(String userInput) {

        List<String> greetings = List.of(
                "hi", "hello", "hey", "howdy"
        );

        for (String greet : greetings) {
            if (userInput.contains(greet)) {
                return "Hello, there!";
            }
        }

        return null;
    }
}