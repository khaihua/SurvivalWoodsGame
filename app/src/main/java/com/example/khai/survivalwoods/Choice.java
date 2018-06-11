package com.example.khai.survivalwoods;

public class Choice {
    private String mText;
    private int mNextPage;
    private int juiceGained;
    private int candybarGained;

    public Choice(String text, int nextPage, int juice, int candybar) {
        this.mText = text;
        this.mNextPage = nextPage;
        this.juiceGained = juice;
        this.candybarGained = candybar;
    }
    public Choice(String text, int nextPage){
        this.mText = text;
        this.mNextPage = nextPage;
        this.juiceGained = 0;
        this.candybarGained = 0;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public int getJuiceGained(){return juiceGained;}
    public int getCandybarGained(){return candybarGained;}

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
