# Console-based Chatbot

This Java chatbot is a simple implementation that uses predefined responses loaded from a JSON file. The chatbot recognizes keywords in user input and provides appropriate responses based on the predefined rules.


## Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/) (for building the project)
- [Jackson Library](https://github.com/FasterXML/jackson) (for handling JSON)


## Usage
Run the **`Main`** class to start the chatbot. The bot will prompt you for input, and it will respond based on the predefined rules in the **`response.json`** file.

Type your input, and the chatbot will respond accordingly. Type "exit" to end the conversation. 


# Configuration
The chatbot's responses are configured in the **`response.json`** file. Each entry in the JSON array represents a set of input keywords, associated responses, and keywords to trigger those responses.


# License
This project is licensed under the [MIT License](LICENSE).
