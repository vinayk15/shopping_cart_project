package com.mindtree.shoppingcart.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book implements Serializable, Comparable<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String genre;
    private String author;
    private String publisher;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Book(String genre, String authour, String publisher, Product product) {
        super();
        this.genre = genre;
        this.author = authour;
        this.publisher = publisher;
        this.product = product;
    }

    public Book() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(product, book.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genre, author, publisher, product);
    }

    @Override
    public int compareTo(Book book) {
        return this.getBookId().compareTo(book.getBookId());
    }
}
