package aop;

import org.springframework.stereotype.Component;

@Component
//        ("libraryBean")
public class UniLibrary extends AbstractLibrary {
//    public void getBook(Book book){
//        System.out.println("We are taking the book: " + book.getName() + "\n");
//    }

    public void getBook(){
        System.out.println("We are taking the book\n");
    }

    public void getBook(int amount){
        System.out.println("We are taking the book. Amount: " + amount + "\n");
    }

    public void returnBook(){
        System.out.println("We are returning the book");
    }

    public void getMagazine(){
        System.out.println("We are taking the magazine\n");
    }

    public void returnMagazine(){
        System.out.println("We are returning the magazine\n");
    }

    public void addBook(){
        System.out.println("We are adding the book\n");
    }

    public void addMagazine(){
        System.out.println("We are adding the magazine\n");
    }
}
