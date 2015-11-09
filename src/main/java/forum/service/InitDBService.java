/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.EmailDAO;
import forum.dao.ForumDAO;
import forum.dao.MessageDAO;
import forum.dao.SubjectDAO;
import forum.dao.UtilisateurDAO;
import forum.entity.Email;
import forum.entity.Forum;
import forum.entity.Message;
import forum.entity.Subject;
import forum.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETY
 */
@Service
public class InitDBService {
    
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    
    @Autowired
    private EmailDAO emailDAO;
    
    @Autowired
    private ForumDAO forumDAO;
    
    @Autowired
    private SubjectDAO subjectDAO;
    
    @Autowired
    private MessageDAO messageDAO;
    
    public void initDB(){
        
        // Supprime
        messageDAO.deleteAll();
        subjectDAO.deleteAll();
        forumDAO.deleteAll();
        emailDAO.deleteAll();
        utilisateurDAO.deleteAll();
        
        // Persiste 3 utils
        Utilisateur emetteur = new Utilisateur(1L, "test", "test", Utilisateur.TypeConnexion.ADMINISTRATEUR);
        utilisateurDAO.save(emetteur);
        
        Utilisateur dest1 = new Utilisateur(2L, "test2", "test2", Utilisateur.TypeConnexion.PREMIUM);
        utilisateurDAO.save(dest1);
        
        Utilisateur dest2 = new Utilisateur(3L, "test3", "test3", Utilisateur.TypeConnexion.UTILISATEUR);
        utilisateurDAO.save(dest2);
        
        // Crée un email
        Email email = new Email(1L, "Test message", "Message du test");
        emailDAO.save(email);
        
        // Association !!! DOUBLE RELATION A SETTER
        dest1.getEmailRecus().add(email);
        email.getDestinataires().add(dest1);
        
        dest2.getEmailRecus().add(email);
        email.getDestinataires().add(dest2);
        
        emetteur.getEmailEnvoyes().add(email);
        email.setOwner(emetteur);
        
        emailDAO.save(email);
        utilisateurDAO.save(dest1);
        utilisateurDAO.save(dest2);
        utilisateurDAO.save(emetteur);
        
        // Cree 3 forums
        Forum forum = new Forum("Test Forum");
        forum.setAdministrateur(emetteur);
        emetteur.getMesForums().add(forum);
        forumDAO.save(forum);
        utilisateurDAO.save(emetteur);
        
        Subject sujet = new Subject("Sujet Test");
        sujet.setForum(forum);
        sujet.setOwner(emetteur);
        forum.getSujets().add(sujet);
        emetteur.getMesSujets().add(sujet);
        subjectDAO.save(sujet);
        utilisateurDAO.save(emetteur);
        forumDAO.save(forum);
        
        Message message = new Message("Test Message");
        message.setOwner(emetteur);
        message.setSujet(sujet);
        sujet.getMessages().add(message);
        emetteur.getMesMessages().add(message);
        messageDAO.save(message);
        subjectDAO.save(sujet);
        utilisateurDAO.save(emetteur);
        
        dest1.getAbonnements().add(forum);
        dest2.getAbonnements().add(forum);
        forum.getAbonnes().add(dest1);
        forum.getAbonnes().add(dest2);
        utilisateurDAO.save(dest1);
        utilisateurDAO.save(dest2);
        forumDAO.save(forum);
    }
    
    public void administrateurCommand(){
        System.out.println("Commande reservee a un administrateur");
    }
}
