package yungshun.chang.springbootticketmanagementaop.aop;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Aspect
@Component
public class TokenRequiredAspect {

    @Before("execution(* yungshun.chang.springbootticketmanagementaop.controller.HomeController.testAOPExecution())")
    public void tokenRequiredWithoutAnnotation() throws Throwable {
        System.out.println("Before tokenRequiredWithExecution");
    }

    @Before("@annotation(tokenRequired)")
    public void tokenRequiredWithAnnotation(TokenRequired tokenRequired) throws Throwable {
        System.out.println("Before tokenRequiredWithAnnotation");

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // Check for token in request header
        String tokenInHeader = request.getHeader("token");
        if (StringUtils.isEmpty(tokenInHeader)) {
            throw new IllegalArgumentException("Empty token");
        }
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SecurityServiceImpl.secretKey))
                .parseClaimsJwts(tokenInHeader)
                .getBody();
        if (claims == null || claims.getSubject() == null) {
            throw new IllegalArgumentException("Token Error : Claim is null");
        }
        if (!claims.getSubject().equalsIgnoreCase("yungshun")) {
            throw new IllegalArgumentException("Subject doesn't match in the token");
        }
    }
}
