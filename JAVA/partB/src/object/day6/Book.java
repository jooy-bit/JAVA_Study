package object.day6;

public class Book {
    private String BookNames;
    private int ISBN;
    private int Price;
    private boolean UsedBook;
    private int UsedBookPrice;

    public Book(String BookNames,int ISBN,int Price,boolean UsedBook,int UsedBookPrice) {
        this.BookNames=BookNames;
        this.ISBN=ISBN;
        this.Price= Price;
        this.UsedBook=UsedBook;
        this.UsedBookPrice=UsedBookPrice;
    }

    //getter
    public String getBookNames() {
        return BookNames;
    }
    public int getISBN() {
        return ISBN;
    }
    public int getPrice() {
        return Price;
    }
    public boolean getUsedBook() {
        return UsedBook;
    }
    public int getUsedBookPrice() {
        return UsedBookPrice;
    }

 /*    public String getData(){
        return System.out.println(
            String.format(
                "%s, %d, %d, %b, %d",
                BookNames,ISBN,Price,UsedBook,UsedBookPrice));
    } */
}
