package com.example.selibrary;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private int id;
    private String ISBN;
    private String publicationDate;
    private int availablecopies;

    public String toString(){
        return "Title=" +getTitle()+ " Id= "+getId()+" ISBN="+getISBN()+"  Publication Date="+getPublicationDate()+" Availablecopies = "+getAvailablecopies();
    }
    Book(){

    }




    public Book(String title, int id, String ISBN, String publicationDate, int availablecopies) {
        this.title = title;
        this.id = id;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.availablecopies = availablecopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getAvailablecopies() {
        return availablecopies;
    }

    public void setAvailablecopies(int availablecopies) {
        this.availablecopies = availablecopies;
    }

    public void updateBook(String title, String ISBN, String publicationDate, int availablecopies) {
        setTitle(title);
        setISBN(ISBN);
        setPublicationDate(publicationDate);
        setAvailablecopies(availablecopies);
    }

    public void issuedStatus(int issueCount) {
        if (availablecopies >= issueCount) {
            availablecopies -= issueCount;
            System.out.println("Book issued successfully");
        } else {
            System.out.println("Book not available");
        }
    }

    public void newBookDemand(String title) {
        System.out.println("New book demand for: " + title);
    }
}

