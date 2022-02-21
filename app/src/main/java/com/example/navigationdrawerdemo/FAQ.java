package com.example.navigationdrawerdemo;

public class FAQ {
    String question;
    String answer;
    boolean visibility;

    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.visibility=false;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
