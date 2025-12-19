import java.util.ArrayList;
import java.util.Scanner;
public class LibraryApp {
    private ArrayList<Book> books=new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);
    private void printMenu(){
        System.out.println("Welcome to the library app!");
        System.out.println("1.Print all books ");
        System.out.println("2. Add new book ");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book ");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
        System.out.print("Choose: ");
    }
    private void printAllbooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
        }else{
            for (Book book:books){
                System.out.println(book);
            }
        }
    }
    private void addNewbook(){
        try{
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            Book book=new Book(title, author, year);
            books.add(book);
            System.out.println("Book added successfully");
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
            scanner.nextLine();
        }
    }
    private void searchBytitle(){
        System.out.print("Enter part of the title: ");
        String search=scanner.nextLine().toLowerCase();
        boolean found=false;
        for (Book book:books){
            if(book.getTitle().toLowerCase().contains(search)){
                System.out.println(book);
                found=true;
            }
        }
        if (!found){
            System.out.println("No books found");
        }
    }
    private void borrowBook(){
        System.out.print("Enter the book id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        for (Book book:books){
            if (book.getId()==id){
                if (book.getAvailable()){
                    book.markAsBorrowed();
                    System.out.println("Book borrowed");
                }else{
                    System.out.println("Book already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
    private void returnBook(){
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(Book book:books){
            if(book.getId()==id){
                if (!book.getAvailable()){
                    book.markAsReturned();
                    System.out.println("Book returned");
                }else{
                    System.out.println("Book was not borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
    private void deleteBook(){
        System.out.print("Enter book id: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<books.size(); i++){
            if(books.get(i).getId()==id) {
                books.remove(i);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }
    public void run(){
        boolean running=true;
        while(running){
            printMenu();
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    printAllbooks();
                    break;
                case 2:
                    addNewbook();
                    break;
                case 3:
                    searchBytitle();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    running=false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
