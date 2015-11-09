package forum.entity;

import forum.entity.Subject;
import forum.entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-09T14:30:17")
@StaticMetamodel(Forum.class)
public class Forum_ { 

    public static volatile SingularAttribute<Forum, Utilisateur> administrateur;
    public static volatile ListAttribute<Forum, Subject> sujets;
    public static volatile SingularAttribute<Forum, String> name;
    public static volatile SingularAttribute<Forum, Long> id;
    public static volatile ListAttribute<Forum, Utilisateur> abonnes;

}