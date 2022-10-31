package org.ttn.springhibernatepart3.manyToMany.entity;

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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="author_book",joinColumns=@JoinColumn(name="authorid",referencedColumnName = "authorid"),
    inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "bookid"))
   private Set<Book> books;

    public Author() {
    }

    public Author(int id, String name, Address address, Set<Subject> subjects, Set<Book> books) {
        this.authorid = id;
        this.name = name;
        this.address = address;
        this.subjects = subjects;
        this.books = books;
    }

    public void addBookDetails(Book bookDetails){
        if(bookDetails!=null){
            if(books==null){
                books=new HashSet<>();
            }
            bookDetails.setAuthor(this);
            books.add(bookDetails);
        }
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", subjects=" + subjects +
                ", books=" + books +
                '}';
    }
}
