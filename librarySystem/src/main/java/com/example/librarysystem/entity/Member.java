package com.example.librarysystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    int memberId;
    String name;
    String password;
    String phoneNumber;
    String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany
    List<Book> bookBorrowed;

    public void addBook(Book book){bookBorrowed.add(book);}
    public void removeBook(Book book) {bookBorrowed.remove(book);}
    public List<Book> getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(List<Book> bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public Member() {
    }

    public int getId() {
        return memberId;
    }

    public void setId(int id) {
        this.memberId = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
