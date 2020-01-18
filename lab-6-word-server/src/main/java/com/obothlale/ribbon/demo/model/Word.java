package com.obothlale.ribbon.demo.model;

public class Word {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word(){
        super();
    }

    public Word(String word){
        this();
        this.word = word;
    }
}
