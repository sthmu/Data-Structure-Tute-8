import ContigousList.ContigousList;
import Interfaces.List;
import Linked.LinkedList;

import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] arrOfBooks = {
                "B001|Data Structures|S. Tanenbaum|2018",
                "B002|Operating Systems|A. Silberschatz|2020",
                "B003|Computer Networks|A. S. Tanenbaum|2017",
                "B004|Java Programming|H. Schildt|2021",
                "B005|Python Crash Course|E. Matthes|2019",
                "B006|Database Management|R. Elmasri|2016",
                "B007|Discrete Mathematics|K. Rosen|2015",
                "B008|Artificial Intelligence|S. Russell|2022",
                "B009|Software Engineering|I. Sommerville|2018",
                "B010|Machine Learning|T. Mitchell|2021"
        };


        LinkedList listOfBooks = new LinkedList();

        for (String entry : arrOfBooks) {
            String[] details = entry.split("\\|");

            Book book = new Book(details[0], details[1], details[2],  Integer.parseInt(details[3]));
            listOfBooks.insertLast(book);
        }
        displayBooksList(listOfBooks);

        System.out.println("Sorting the books based on year using selection sort...\n\n\n");
        listOfBooks.selectionSort();


        System.out.println("Sorted List of Books:");
        displayBooksList(listOfBooks);
        System.out.println("\n\n\niii ).\n\ta.");
        System.out.println("Sequential search");
        System.out.print("\n\nEnter the year of the book to search: ");
        String searchYear = input.nextLine();
        displayBooksList(listOfBooks.sequentialSearch(new Book(Integer.parseInt(searchYear))));

        ContigousList ConBookList = new ContigousList(listOfBooks.listSize());
        for (int i = 0; i < listOfBooks.listSize(); i++) {
            ConBookList.insertLast(listOfBooks.retrieveList(i));
        }
        System.out.println("\n\n\niii ).\n\tb.");
        System.out.println("Binary search");
        System.out.print("\nEnter the year of the book to search: ");
        searchYear = input.nextLine();

        displayBooksList(ConBookList.binarySearch(new Book(Integer.parseInt(searchYear))));
        System.out.println("The Search mechanism is working");



    }
    static void displayBooksList(List<Book> bookList){
        if(bookList.isListEmpty()){
            System.out.println("The list is empty.");
            return;
        }
        System.out.printf("%-10s %-27s %-20s %-5s%n", "bookId", "Title", "Author", "Year");
        System.out.println("-------------------------------------------------------------------------");
        for(int i=0;i<bookList.listSize();i++){
            System.out.printf("%-10s %-27s %-20s %-5s%n",
                    bookList.retrieveList(i).getBookId(),
                    bookList.retrieveList(i).getBookName(),
                    bookList.retrieveList(i).getAuthorName(),
                    bookList.retrieveList(i).getYear());
        }

    }

}


class Book implements Comparable<Book> {
    private String bookId;
    private String bookName;
    private String authorName;
    private int year;


    public Book(String bookId, String bookName, String authorName, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.year = year;
    }
    public Book(int year) {
        this.year = year;
    }


    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.year, o.year);
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYear() {
        return year;
    }
}
