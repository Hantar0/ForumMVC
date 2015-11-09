package forum.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import forum.entity.Email;
import forum.entity.Utilisateur;
import forum.service.InitDBService;
import forum.service.security.SecurityService;
import forum.service.UtilisateurService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class ForumTests {
    
    @Autowired
    private InitDBService initDBService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private SecurityService securityService;
    
    @Before
    public void avant(){
        
        initDBService.initDB();
    }
   
    @Test
    public void testBdd(){
        Assert.assertEquals("test test", utilisateurService.findOne(1L).getLogin()+" "+utilisateurService.findOne(1L).getMdp());
//        Assert.assertEquals("Test Forum", utilisateurDAO.findOne(1L).getMesForums().get(0).getName());
//        Assert.assertEquals("Sujet Test", utilisateurDAO.findOne(1L).getMesSujets().get(0).getName());
//        Assert.assertEquals("Test Message", utilisateurDAO.findOne(1L).getMesMessages().get(0).getMessage()); 
        
        Email email = new Email(2L, "Test deuxieme message", "Message 2");
        List<Long> destinatairesId = new ArrayList<Long>();
        destinatairesId.add(2L);
        destinatairesId.add(3L);
        Long ownerId = 1L;
        
        utilisateurService.sendEmail(email, ownerId, destinatairesId);
        
        System.out.println(utilisateurService.findOne(1L).getEmailEnvoyes().get(0).getMessage());
        System.out.println(utilisateurService.findOne(1L).getEmailEnvoyes().get(1).getMessage());
        
        Utilisateur utilisateur = utilisateurService.findOneByLogin("test");
        Assert.assertEquals("test", utilisateur.getMdp());
        
        System.out.println(utilisateur.getLogin()+"    "+utilisateur.getMdp());
        
        //initDBService.administrateurCommand();
    }
}
