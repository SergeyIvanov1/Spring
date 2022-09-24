package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void getBook(String))")
    public void beforeGetBookAdvice(){
        System.out.println("Log: beforeGetBookAdvice");
    }

    @Before("execution(public void getBook(aop.Book))")
    public void beforeGetBookWithParameterBookAdvice(){
        System.out.println("Log: beforeGetBookWithParameterBookAdvice");
    }

    @Before("execution(public void getBook(*))")
    public void beforeGetBookWithAnyParameterAdvice(){
        System.out.println("Log: method beforeGetBookWithAnyParameterAdvice - Attempt to get the book");
    }

    @Before("execution(public void *(*))")
    public void beforeAnyMethodWithAnyOneParameterAdvice(){
        System.out.println("Log: method beforeAnyMethodWithAnyOneParameterAdvice - Attempt to get the book");
    }

    @Before("execution(public void *(..))")
    public void beforeAnyMethodWithAnyAmountOfAnyParametersAdvice(){
        System.out.println("Log: method beforeAnyMethodWithAnyAmountOfAnyParametersAdvice");

    @Before("execution(public void getBook())")
    public void beforeGettingBookAdvice(){
        System.out.println("Log: beforeGettingBookAdvice - Attempt to get the book\n");
    }

    @Before("execution(public void get*())")
    public void beforeAnyMethodWithStartGetAdvice(){
        System.out.println("Log: beforeAnyMethodWithStartGetAdvice - Attempt to get the book (public void get*()))\n");
    }

    @Before("execution(public * returnBook())")
    public void beforeReturnBookWithAnyReturnTypeAdvice(){
        System.out.println("Log: beforeReturnBookWithAnyReturnTypeAdvice - Attempt to return the book (public * returnBook())\n");
    }

    @Before("execution(public * *())")
    public void beforeAnyMethodsAdvice(){
        System.out.println("Run: beforeAnyMethodsAdvice (public * *())\n");
    }
}
