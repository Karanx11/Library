package model;

public class Book{
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int copies;
    private int totalCopies;

    public Book(int id, String title, String author, String publisher, int year, int copies, int totalCopies) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalCopies = totalCopies;
        this.copies = totalCopies;
    }

    public int getId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getCopies() {
        return copies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void increaseCopies(){
        this.copies += 1;
    }

    public void decreaseCopies(){
        if(copies > 0){
            this.copies -= 1;
        }
    }

    public String fullDetails(){
        return "Book ID:" + bookId + "| Title:" +title+ "| Author:" + author + "| Publisher:" + publisher + "| Year: " + copies + "/" + totalCopies;
    }
}