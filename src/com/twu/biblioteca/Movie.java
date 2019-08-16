package com.twu.biblioteca;

public class Movie {
    String name;
    String year;
    String director;
    String rating;
    Boolean checkedOut;

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
        checkedOut = false;
    }

    public Boolean getCheckedOutStatus(){
        return checkedOut;
    }
}
