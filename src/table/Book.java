package table;

import java.util.Date;

public class Book {
    private int book_id;
    private String title;
    private int author_id;
    private int publisher_id;
    private Date published_date;
    private String isbn;
    private int category_id;
    private String language;
    private int pages;
    private String description;
    private int total_copies;
    private int available_copies;
    private String location;
    public Book() {

    }
    public Book(int bookId, String title, int authorId, int publisherId, Date publishedDate, String isbn,
                int categoryId, String language, int pages, String description, int totalCopies,
                int availableCopies, String location) {
        this.book_id = bookId;
        this.title = title;
        this.author_id = authorId;
        this.publisher_id = publisherId;
        this.published_date = publishedDate;
        this.isbn = isbn;
        this.category_id = categoryId;
        this.language = language;
        this.pages = pages;
        this.description = description;
        this.total_copies = totalCopies;
        this.available_copies = availableCopies;
        this.location = location;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal_copies() {
        return total_copies;
    }

    public void setTotal_copies(int total_copies) {
        this.total_copies = total_copies;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + book_id +
                ", title='" + title + '\'' +
                ", authorId=" + author_id +
                ", publisherId=" + publisher_id +
                ", publishedDate=" + published_date +
                ", isbn='" + isbn + '\'' +
                ", categoryId=" + category_id +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                ", totalCopies=" + total_copies +
                ", availableCopies=" + available_copies +
                ", location='" + location + '\'' +
                '}';
    }
}
