/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.EmailDAO;
import forum.dao.UtilisateurDAO;
import forum.entity.Email;
import forum.entity.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class UtilisateurService  {
    
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    
    @Autowired
    private EmailService emailService;

    @Transactional
    public <S extends Utilisateur> S save(S s) {
        return utilisateurDAO.save(s);
    }

    public Utilisateur findOne(Long id) {
        return utilisateurDAO.findOne(id);
    }
    
    public Utilisateur findOneByLogin(String login) {
        return utilisateurDAO.findOneByLogin(login);
    }

    public Iterable<Utilisateur> findAll() {
        return utilisateurDAO.findAll();
    }

    @Transactional
    public void delete(Long id) {
        utilisateurDAO.delete(id);
    }

    @Transactional
    public void delete(Utilisateur t) {
        utilisateurDAO.delete(t);
    }

    @Transactional
    public void deleteAll() {
        utilisateurDAO.deleteAll();
    }
    
//    public boolean login(String login, String mdp){
//        
//    }
    
    @Transactional
    public void sendEmail(Email email, Long ownerId, List<Long> destinatairesId){
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Utilisateur owner = utilisateurDAO.findOne(ownerId);
        for(Long id:destinatairesId){
            Utilisateur utilisateur = utilisateurDAO.findOne(id);
            utilisateurs.add(utilisateur);
            email.getDestinataires().add(utilisateur);
        }
        
        email.setOwner(owner);
        owner.getEmailEnvoyes().add(email);
        for(Utilisateur utilisateur:utilisateurs){
            utilisateur.getEmailRecus().add(email);
            utilisateurDAO.save(utilisateur);
        }
        emailService.save(email);
        utilisateurDAO.save(owner);
    }
    
}
