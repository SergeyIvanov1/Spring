package aop;

import org.springframework.stereotype.Component;

@Component
//        ("libraryBean")
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook(){
        System.out.println("We are taking the book from UniLibrary");
    }

    public void returnBook() {
        System.out.println("We are returning the book from UniLibrary");
    }

    public void getMagazine() {
        System.out.println("We are taking the magazine from UniLibrary");
    }
}
