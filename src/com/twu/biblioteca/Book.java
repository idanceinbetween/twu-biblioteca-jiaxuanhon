package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private Boolean checkedOut = false;
    private User loaner = null;

    public Book(String titleStr, String authorStr, String yearStr) {
        title = titleStr;
        author = authorStr;
        year = yearStr;
    }


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

    public void setLoaner(User user){
        loaner = user;
    }

    public User getLoaner(){
        return loaner;
    }

    public void removeLoaner(User user){
        loaner = null;
    }

}
