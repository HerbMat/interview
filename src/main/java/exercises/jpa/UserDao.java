package exercises.jpa;

import exercises.jpa.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void deactivateUser(Integer userId) {
//        Session session = sessionFactory.getCurrentSession();
//
//        //It should be session.find(User.class, userId);
//        User user = user.find(User.class, userId);
//        user.setActive(false);
//        session.update(user);
//        //If we want to save changes to database we should call session.flush() after update call.
//    }
//
//    public List<User> getListOfUsersWithoutPassword() {
//        //I would change query to "SELECT new package.User(u.id, u.username, u.active) FROM User u"
//        //Or used ResultTransformer.
//        Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u");
//
//        List<User> users = query.list();
//
//        // For each is obsolete and I would remove that.
//        users.forEach(u -> {
//            u.setPassword(null);
//            //for each takes only consumers so it can't return anything.
//            return u;
//        });
//        return users;
//    }
}
