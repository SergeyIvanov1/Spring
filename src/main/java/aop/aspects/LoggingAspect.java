package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Before("execution(public void getBook(String))")
//    public void beforeGetBookAdvice(){
//        System.out.println("Log: beforeGetBookAdvice");
//    }
//
//    @Before("execution(public void getBook(aop.Book))")
//    public void beforeGetBookWithParameterBookAdvice(){
//        System.out.println("Log: beforeGetBookWithParameterBookAdvice");
//    }
//
//    @Before("execution(public void getBook(*))")
//    public void beforeGetBookWithAnyParameterAdvice(){
//        System.out.println("Log: method beforeGetBookWithAnyParameterAdvice - Attempt to get the book");
//    }
//
//    @Before("execution(public void *(*))")
//    public void beforeAnyMethodWithAnyOneParameterAdvice(){
//        System.out.println("Log: method beforeAnyMethodWithAnyOneParameterAdvice - Attempt to get the book");
//    }
//
//    @Before("execution(public void *(..))")
//    public void beforeAnyMethodWithAnyAmountOfAnyParametersAdvice() {
//        System.out.println("Log: method beforeAnyMethodWithAnyAmountOfAnyParametersAdvice");
//    }
//
//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookWithAnyReturnTypeAdvice(){
//        System.out.println("Log: beforeReturnBookWithAnyReturnTypeAdvice - Attempt to return the book (public * returnBook())\n");
//    }



    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void before_Add_LOG_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
             Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Info about book:\n" +
                            "book name - " + myBook.getName() + "\n" +
                            "author - " + myBook.getAuthor() + "\n" +
                            "yearOfPublication - " + myBook.getYearOfPublication());
                } else if (obj instanceof String){
                    System.out.println("the book is adding to the library - " + obj);
                }
            }
        }
        System.out.println("Log: before_Add_LOG_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice");
    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLogAdvice(){
//        System.out.println("beforeGetLogAdvice (\"execution(* aop.UniLibrary.get*())\")");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLogAdvice(){
//        System.out.println("beforeReturnLogAdvice (\"execution(* aop.UniLibrary.return*())\")");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLogAdvice(){
//        System.out.println("beforeGetAndReturnLogAdvice (allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary())");
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void beforeReturnMagazineAdvice(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !beforeReturnMagazineAdvice()")
//    private void beforeAnyMethodsButNotReturnMagazine(){}
//
//    @Before("beforeAnyMethodsButNotReturnMagazine()")
//    public void beforeAllMethodsExceptReturnMagazineFromUniLibraryAdvice(){
//        System.out.println("allMethodsExceptReturnMagazineFromUniLibrary");
//    }


}
