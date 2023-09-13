package com.example.geoquiz;

public class Question {
    private String sentence;
    private boolean answer;

    public Question(String sentence, boolean answer) {
        this.sentence = sentence;
        this.answer = answer;
    }

    public String getSentence() {
        return sentence;
    }

    public boolean isAnswer() {
        return answer;
    }
}
