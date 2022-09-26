package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: trying to return the book to the library");

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed(); // only manually can invoke the method returnBook()
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: catch exception" + e);
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: to the library success returned the book");
        return targetMethodResult;
    }
}
