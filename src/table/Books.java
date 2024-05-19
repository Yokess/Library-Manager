package table;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Books {
    private List<Book> books=new ArrayList<Book>();
    private Connection conn;
    private int count=0;

    public Books(Connection connection){
        this.conn=connection;

    }
    public int getCount(){
        return books.size();
    }
    public void setCount(){
        count=books.size();
    }

    public void loadBooks(){
        String sql="select * from books";
        try{
            PreparedStatement statement= (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int bookId=rs.getInt("book_id");
                String title = rs.getString("title");
                int authorId = rs.getInt("author_id");
                int publisherId = rs.getInt("publisher_id");
                Date publishedDate = rs.getDate("published_date");
                String isbn = rs.getString("isbn");
                int categoryId = rs.getInt("category_id");
                String language = rs.getString("language");
                int pages = rs.getInt("pages");
                String description = rs.getString("description");
                int totalCopies = rs.getInt("total_copies");
                int availableCopies = rs.getInt("available_copies");
                String location = rs.getString("location");
                Book book = new Book(bookId, title, authorId, publisherId, publishedDate, isbn,
                        categoryId, language, pages, description, totalCopies, availableCopies, location);
                books.add(book);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        setCount();
    }
    public void printBooks(){
        for(Book book:books){
            System.out.println(book.toString());
        }
    }



    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
