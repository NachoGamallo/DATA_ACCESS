package org.example.RepasoJava;

import java.text.Format;

public class Movie extends Multimedia{

    private String principalActor;
    private String principalActress;

    byte gender;
    public Movie(String title, String author, String format, double time) {

        super(title, author, format, time);

    }

    public Movie(String title, String author, String format, double time, String principalActor, String principalActress) {
        super(title, author, format, time);
        this.principalActor = principalActor;
        this.principalActress = principalActress;

    }

    public Movie(String title, String author, String format, double time, String principal, byte gender) {

        super(title, author, format, time);

        this.gender = gender;

        if (principal != null){

            if ( gender == 0 ){

                this.principalActor = principal;

            }else {

                this.principalActress = principal;

            }

        }

    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getPrincipalActor() {
        return principalActor;
    }

    public void setPrincipalActor(String principalActor) {
        this.principalActor = principalActor;
    }

    public String getPrincipalActress() {
        return principalActress;
    }

    public void setPrincipalActress(String principalActress) {
        this.principalActress = principalActress;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "principalActor='" + principalActor + '\'' +
                ", principalActress='" + principalActress + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", format='" + getFormat() + '\'' +
                ", time=" + time +
                '}';
    }
}
