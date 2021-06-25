package yungshun.chang.springbootticketmanagementaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TokenRequiredAspect {

    @Before("execution(* yungshun.chang.springbootticketmanagementaop.controller.HomeController.testAOPExecution())")
    public void tokenRequiredWithoutAnnotation() throws Throwable {
        System.out.println("Before tokenRequiredWithExecution");
    }

}
