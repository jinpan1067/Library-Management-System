package com.example.librarysystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String subject;
    String title;
    String author;
    String publisher;
    int copyright;
    int edition;
    int pages;
    String ISBN;
    int shelfNo;
    String returnDate;
    boolean status = true;


    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book() {
    }

    public Book(String subject, String title, String author, String publisher,
                int copyright, int edition, int pages, String ISBN, int shelfNo
                ) {
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copyright = copyright;
        this.edition = edition;
        this.pages = pages;
        this.ISBN = ISBN;
        this.shelfNo = shelfNo;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(int shelfNo) {
        this.shelfNo = shelfNo;
    }

    @Override
    public String toString() {
        return "Book ID ="
                 + id +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\''+
                ", return date ='" +returnDate ;

    }
}
