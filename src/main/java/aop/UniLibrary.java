package aop;

import org.springframework.stereotype.Component;

@Component
//        ("libraryBean")
public class UniLibrary extends AbstractLibrary {
    public void getBook(Book book){
        System.out.println("We are taking the book: " + book.getName() + "\n");
    }

    public void getBook(int amount){
        System.out.println("We are taking the book. Amount: " + amount + "\n");
    }

    public void getMagazine(){
        System.out.println("We are taking the magazine" + "\n");
    }
}
