package com.aluracursos.screenmatch.screenmatch_v3.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class GPTQuery {
    public static String getTranslation(String synopsis) {
        OpenAiService service = new OpenAiService("sk-proj-woEXMzEWX4NhjwJqssu9T3BlbkFJRuWcjgWqAjly71Jjxxki");

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Translate to spanish the text: " + synopsis)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
