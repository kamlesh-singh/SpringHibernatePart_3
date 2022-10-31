package org.ttn.springhibernatepart3.oneToOne.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookid;

    @Column(name = "bookname")
    private String bookName;

    @OneToOne
    @JoinColumn(name = "authorid")
    private Author author;

    public Book() {
    }

    public Book(int id, String bookName, Author author) {
        this.bookid = id;
        this.bookName = bookName;
        this.author = author;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
