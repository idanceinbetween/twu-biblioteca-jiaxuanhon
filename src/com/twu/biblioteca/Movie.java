package com.twu.biblioteca;

public class Movie {
    String name;
    String year;
    String director;
    String rating;
    Boolean checkedOut;
    User loaner;

    public Movie(String nameStr, String yearStr, String directorStr) {
        name = nameStr;
        year = yearStr;
        director = directorStr;
        rating = "Nil";
        checkedOut = false;
    }

    public String getName(){
        return name;
    }
    public String getYear(){
        return year;
    }
    public String getDirector(){
        return director;
    }
    public String getRating(){
        return rating;
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
