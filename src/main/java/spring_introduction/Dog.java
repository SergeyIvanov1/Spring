package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

//@Component
//@Scope("prototype")
public class Dog implements Pet{
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

//    @PostContract
//    protected void  init(){
//        System.out.println("Class Dod: init method");
//    }
//
//    @PreDestroy
//    private void destroy(){
//        System.out.println("Class Dod: destroy method");
//    }
}
