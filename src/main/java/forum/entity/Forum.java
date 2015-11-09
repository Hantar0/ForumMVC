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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Forum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @ManyToMany(mappedBy = "abonnements")
    private List<Utilisateur> abonnes = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur administrateur;
    
    @OneToMany(mappedBy = "forum")
    private List<Subject> sujets = new ArrayList<>();

    public Forum() {
    }

    public Forum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Utilisateur> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<Utilisateur> abonnes) {
        this.abonnes = abonnes;
    }

    public Utilisateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Utilisateur administrateur) {
        this.administrateur = administrateur;
    }

    public List<Subject> getSujets() {
        return sujets;
    }

    public void setSujets(List<Subject> sujets) {
        this.sujets = sujets;
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
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Forum[ id=" + id + " ]";
    }
    
}
