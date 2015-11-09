/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Utilisateur implements Serializable {
    
    public enum TypeConnexion{
        ADMINISTRATEUR, UTILISATEUR, PREMIUM;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String mdp;
    
    @Enumerated(EnumType.STRING)
    private TypeConnexion type;
    
    @ManyToMany
    @JoinTable( name = "utilisateurs_abonnements",
                joinColumns = @JoinColumn(name="utilisateurId"),
                inverseJoinColumns = @JoinColumn(name="forumId")
    )
    private List<Forum> abonnements = new ArrayList<Forum>();
    
    @OneToMany(mappedBy = "administrateur")
    private List<Forum> mesForums = new ArrayList<Forum>();
    
    @OneToMany(mappedBy = "owner")
    private List<Subject> mesSujets = new ArrayList<Subject>();
    
    @OneToMany(mappedBy = "owner")
    private List<Message> mesMessages = new ArrayList<Message>();
    
    @OneToMany(mappedBy = "owner")
    private List<Email> emailEnvoyes = new ArrayList<Email>();
    
    @ManyToMany
    @JoinTable( name = "utilisateurs_emails",
                joinColumns = @JoinColumn(name="utilisateurId"),
                inverseJoinColumns = @JoinColumn(name="emailId")
    )
    private List<Email> emailRecus = new ArrayList<Email>();

    public Utilisateur() {
    }
    
    public Utilisateur(Long id, String login, String mdp, TypeConnexion type) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.type = type;
    }

    public List<Email> getEmailEnvoyes() {
        return emailEnvoyes;
    }

    public void setEmailEnvoyes(List<Email> emailEnvoyes) {
        this.emailEnvoyes = emailEnvoyes;
    }

    public List<Email> getEmailRecus() {
        return emailRecus;
    }

    public void setEmailRecus(List<Email> emailRecus) {
        this.emailRecus = emailRecus;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public TypeConnexion getType() {
        return type;
    }

    public void setType(TypeConnexion type) {
        this.type = type;
    }

    public List<Forum> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Forum> abonnements) {
        this.abonnements = abonnements;
    }

    public List<Forum> getMesForums() {
        return mesForums;
    }

    public void setMesForums(List<Forum> mesForums) {
        this.mesForums = mesForums;
    }

    public List<Subject> getMesSujets() {
        return mesSujets;
    }

    public void setMesSujets(List<Subject> mesSujets) {
        this.mesSujets = mesSujets;
    }

    public List<Message> getMesMessages() {
        return mesMessages;
    }

    public void setMesMessages(List<Message> mesMessages) {
        this.mesMessages = mesMessages;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
