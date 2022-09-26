package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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



    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void before_GET_LOG_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice(){
        System.out.println("Log: before_GET_LOG_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice");
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
