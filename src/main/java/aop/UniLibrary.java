package aop;

import org.springframework.stereotype.Component;

@Component //("libraryBean")
public class UniLibrary extends AbstractLibrary {
//    public void getBook(Book book){
//        System.out.println("We are taking the book: " + book.getName() + "\n");
//    }

    public void getBook(){
        System.out.println("We are taking the book\n");
        System.out.println("_________________________________");
    }

    public void getBook(int amount){
        System.out.println("We are taking the book. Amount: " + amount + "\n");
        System.out.println("_________________________________");
    }

    public String returnBook(){
        int exception = 15/0;
        System.out.println("We are returning the book");
        return "War and peace";
    }

    public void getMagazine(){
        System.out.println("We are taking the magazine\n");
        System.out.println("_________________________________");

    }

    public void returnMagazine(){
        System.out.println("We are returning the magazine\n");
        System.out.println("_________________________________");
    }

    public void addBook(String person_name, Book book){
        System.out.println("We are adding the book\n");
        System.out.println("_________________________________");
    }

    public void addMagazine(){
        System.out.println("We are adding the magazine\n");
        System.out.println("_________________________________");
    }
}
