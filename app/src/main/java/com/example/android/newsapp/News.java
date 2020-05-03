package com.example.android.newsapp;
/*
* News object template
* */

public class News {

    //member variables declaration
    //this holds the the section a news belongs
    private String mSectionName;

    //this holds the title of the news
    private String mTitle;

    //this holds the author of the article
    private String mAuthor;

    //this holds the date the news was published
    private String mPublicationDate;

    //this holds the link to the news on the Guardian web
    private String mUrl;

    //News Object Constructor
    public News(String sectionName, String title, String author, String publicationDate, String url) {
        mSectionName = sectionName;
        mTitle = title;
        mAuthor = author;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    //Setting getters for member variables
    public String getSectionName() {
        return mSectionName;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
