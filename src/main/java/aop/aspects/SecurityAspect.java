package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void before_GET_SECURITY_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice(){
        System.out.println("Security: before_GET_SECURITY_WithoutModifierAnyReturnTypeAnyMethodStartWithGetWithoutParametersAdvice");
    }

}
