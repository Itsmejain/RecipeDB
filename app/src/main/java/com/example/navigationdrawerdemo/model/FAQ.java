package com.example.navigationdrawerdemo.model;

public class FAQ {
    public String question;
    public String answer;
    public boolean visibility;

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
