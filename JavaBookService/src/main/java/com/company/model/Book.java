package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String issued;
    private String title;
    private String language;
    private String authors;
    private String subjects;
    private String locc;
    private String bookshelves;
    private String url;
    private String as_html;

    public Book() {}

    public Book(
            int id,
            String type,
            String issued,
            String title,
            String language,
            String authors,
            String subjects,
            String locc,
            String bookshelves,
            String url,
            String as_html) {

        this.id = id;
        this.type = type;
        this.issued = issued;
        this.title = title;
        this.language = language;
        this.authors = authors;
        this.subjects = subjects;
        this.locc = locc;
        this.bookshelves = bookshelves;
        this.url = url;
        this.as_html = as_html;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getLocc() {
        return locc;
    }

    public void setLocc(String locc) {
        this.locc = locc;
    }

    public String getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(String bookshelves) {
        this.bookshelves = bookshelves;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAs_html() {
        return as_html;
    }

    public void setAs_html(String as_html) {
        this.as_html = as_html;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(type, book.type) && Objects.equals(issued, book.issued) && Objects.equals(title, book.title) && Objects.equals(language, book.language) && Objects.equals(authors, book.authors) && Objects.equals(subjects, book.subjects) && Objects.equals(locc, book.locc) && Objects.equals(bookshelves, book.bookshelves) && Objects.equals(url, book.url) && Objects.equals(as_html, book.as_html);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, issued, title, language, authors, subjects, locc, bookshelves, url, as_html);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", issued='" + issued + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", authors='" + authors + '\'' +
                ", subjects='" + subjects + '\'' +
                ", locc='" + locc + '\'' +
                ", bookshelves='" + bookshelves + '\'' +
                ", url='" + url + '\'' +
                ", as_html='" + as_html + '\'' +
                '}';
    }
}
