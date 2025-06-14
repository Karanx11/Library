package manager;
import java.util.*;
import model.*;



public class LibraryManager {
    
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<User>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book getBookbyId(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public User getUserbyId(int id) {
        for (User u : users) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        return null;
    } 

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(b.getTitle());
            }
        }
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public void searchBookBytittle(String k){
        String keyword=k.toLowerCase();
        boolean found = false;
        for(Book b:books){
           String bTitle = b.getTitle().toLowerCase();
           if(bTitle.contains(keyword)){
            System.out.println(b);
            found=true;
           }
        }
        if (found==false){
            System.out.println("Book not found");
        }

    }

    public void borrowBook(int bookId, int userId){
    Book b = getBookbyId(bookId);
    User u = getUserbyId(userId);
    if(u!=null && b!=null&&b.getCopies() > 0){
        b.decreaseCopies();
        u.borrowBook(bookId);
        System.out.println("Book borrowed successfully");
    }
    else{
        System.out.println("Book not found or user not found");
    }

    }
    public void returnBook(int bookId, int userId) {
        User u = getUserbyId(userId);
        Book b = getBookbyId(bookId);

        if (u != null && b != null) {
            if (u.getBorrowedBooks().contains(bookId)) {
                u.returnBook(bookId);
                b.increaseCopies();
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("User did not borrow this book.");
            }
        } else {
            System.out.println("Invalid book or user.");
        }
    }

}