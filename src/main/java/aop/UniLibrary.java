package aop;

import org.springframework.stereotype.Component;

@Component
//        ("libraryBean")
public class UniLibrary extends AbstractLibrary {
    public void getBook(){
        System.out.println("We are taking the book");
    }
}
