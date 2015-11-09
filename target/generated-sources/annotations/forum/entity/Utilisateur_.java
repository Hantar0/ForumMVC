package forum.entity;

import forum.entity.Email;
import forum.entity.Forum;
import forum.entity.Message;
import forum.entity.Subject;
import forum.entity.Utilisateur.TypeConnexion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-09T14:30:17")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile ListAttribute<Utilisateur, Message> mesMessages;
    public static volatile ListAttribute<Utilisateur, Forum> abonnements;
    public static volatile ListAttribute<Utilisateur, Forum> mesForums;
    public static volatile SingularAttribute<Utilisateur, String> mdp;
    public static volatile ListAttribute<Utilisateur, Email> emailEnvoyes;
    public static volatile ListAttribute<Utilisateur, Email> emailRecus;
    public static volatile SingularAttribute<Utilisateur, Long> id;
    public static volatile SingularAttribute<Utilisateur, String> login;
    public static volatile SingularAttribute<Utilisateur, TypeConnexion> type;
    public static volatile ListAttribute<Utilisateur, Subject> mesSujets;

}