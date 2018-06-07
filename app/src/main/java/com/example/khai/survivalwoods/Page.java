package com.example.khai.survivalwoods;

public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private Choice mChoice3;
    private Choice mChoice4;
    private boolean mIsFinal = false;

    public Page (int imageId, String text, Choice choice1, Choice choice2 , Choice choice3, Choice choice4) {
        this.mChoice1 = choice1;
        this.mChoice2 = choice2;
        this.mChoice3 = choice3;
        this.mChoice4 = choice4;
        this.mText = text;
        this.mImageId = imageId;
    }
    public Page (int imageId, String text, Choice choice1, Choice choice2 , Choice choice3) {
        this.mChoice1 = choice1;
        this.mChoice2 = choice2;
        this.mChoice3 = choice3;
        this.mText = text;
        this.mImageId = imageId;
    }
    public Page (int imageId, String text, Choice choice1, Choice choice2) {
        this.mChoice1 = choice1;
        this.mChoice2 = choice2;
        this.mText = text;
        this.mImageId = imageId;
    }
    public Page (int imageId, String text, Choice choice1) {
        this.mChoice1 = choice1;
        this.mText = text;
        this.mImageId = imageId;
    }
    public Page (int imageId, String text) {
        this.mChoice4 = null;
        this.mChoice3 = null;
        this.mChoice2 = null;
        this.mChoice1 = null;

        this.mText = text;
        this.mImageId = imageId;
        this.mIsFinal = true;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
    public Choice getChoice3() {
        return mChoice3;
    }

    public void setChoice3(Choice choice3) {
        mChoice3 = choice3;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setIsFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }
    public Choice getChoice4() {
        return mChoice4;
    }

    public void setChoice4(Choice choice4) {
        mChoice4 = choice4;
    }
}
