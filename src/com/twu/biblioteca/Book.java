package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private Boolean checkedOut = false;

    public void setTitle(String t){
        title = t;
    }

    public void setAuthor(String a){
        author = a;
    }

    public void setYear(String y){
        year = y;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getYear(){
        return year;
    }

    public void setCheckOut(){
        checkedOut = true;
    }

    public void setReturn(){
        checkedOut = false;
    }

    public Boolean getCheckedOutStatus(){
        return checkedOut;
    }

}
