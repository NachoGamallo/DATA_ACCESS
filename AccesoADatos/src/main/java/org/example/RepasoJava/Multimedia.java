package org.example.RepasoJava;

public class Multimedia {
    static final String [] formats  = {"wav", "mp3", "midi", "avi", "mov", "mpg", "cd", "dvd"};
    private String title;
    private String author;
    private String format;

    double time;

    public Multimedia(String title, String author, String format, double time) {
        this.title = title;
        this.author = author;
        this.format = format;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime (double time){ this.time = time;}

    public double getTime (){ return this.time;}
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean equals (Multimedia multimedia){
        return multimedia.getAuthor().equalsIgnoreCase(multimedia.getTitle());
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

}
