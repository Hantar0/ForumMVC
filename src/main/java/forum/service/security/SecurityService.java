/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service.security;

import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class SecurityService {
    public boolean verifierAcces(String nomMethod){
        boolean test = true;
        if(nomMethod.startsWith("admin"))
            test = false;
        
        return test;
    }
}
