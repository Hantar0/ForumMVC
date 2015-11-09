package forum.entity;

import forum.entity.Forum;
import forum.entity.Message;
import forum.entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-09T14:30:17")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile SingularAttribute<Subject, Utilisateur> owner;
    public static volatile SingularAttribute<Subject, Forum> forum;
    public static volatile SingularAttribute<Subject, String> name;
    public static volatile ListAttribute<Subject, Message> messages;
    public static volatile SingularAttribute<Subject, Long> id;

}