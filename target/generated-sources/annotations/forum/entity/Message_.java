package forum.entity;

import forum.entity.Subject;
import forum.entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-09T14:30:17")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Utilisateur> owner;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, String> message;
    public static volatile SingularAttribute<Message, Subject> sujet;

}