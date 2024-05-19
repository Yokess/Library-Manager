import com.mysql.jdbc.Connection;
import form.LoginForm;
import form.SignForm;
import table.Books;
import util.DBConnect;

public class Main {
    public static void main(String[] args) {
        DBConnect myDB = new DBConnect();
        myDB.connect();
        Books bookList=new Books((Connection) myDB.getConnection());
        bookList.loadBooks();
        bookList.printBooks();

        new LoginForm();
        myDB.disconnect();
    }
}