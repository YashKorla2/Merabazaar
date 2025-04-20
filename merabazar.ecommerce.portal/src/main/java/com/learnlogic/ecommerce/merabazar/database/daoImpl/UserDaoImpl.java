package com.learnlogic.ecommerce.merabazar.database.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;






import com.learnlogic.ecommerce.merabazar.database.dao.UserDao;
import com.learnlogic.ecommerce.merabazar.model.Users;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	public void createUser(Users users) {
		// TODO Auto-generated method stub
        getSession().persist(users);
	}

	public void updateUser(Users users) {
		// TODO Auto-generated method stub
        getSession().update(users);
	}

	public List<Users> retriveAll() {
		// TODO Auto-generated method stub
        return getSession().createQuery("from Users", Users.class).list();
	}

    public Users retriveById(Long userId) {
		// TODO Auto-generated method stub
        return getSession().get(Users.class, userId);
	}

}
