package org.ttn.springhibernatepart3.oneToOne.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorid;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER,targetClass = Subject.class)
    private Set<Subject> subjects=new HashSet<>();

    @OneToOne(mappedBy = "author",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Book book;

    public Author() {
    }

    public Author(int id, String name, Address address, Set<Subject> subjects, Book books) {
        this.authorid = id;
        this.name = name;
        this.address = address;
        this.subjects = subjects;
        this.book = books;
    }


    public int getId() {
        return authorid;
    }

    public void setId(int id) {
        this.authorid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", subjects=" + subjects +
                ", books=" + book +
                '}';
    }
}
