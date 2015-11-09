/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.aspect;

import forum.service.security.SecurityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kk
 */
@Aspect
@Component
public class SecurityAspect {
    
    @Autowired
    private SecurityService securityService;
    
    @Before("execution(* forum.service.*.*(..))")
    public void securServ(JoinPoint jp){
        if(!securityService.verifierAcces(jp.getSignature().getName()))
            throw new RuntimeException("Erreur de securite!");
    }
}
