package com.learnlogic.ecommerce.merabazar.database.daoImpl;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;






import com.learnlogic.ecommerce.merabazar.database.dao.UserDao;
import com.learnlogic.ecommerce.merabazar.model.Users;

// Hint for Q: Implement logging mechanisms to track all requests
// Hint for Q: Implement validations wherever necessary
// Hint for Q: Use async-await if possible

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

	public void createUser(Users users) {
		// TODO Auto-generated method stub
        entityManager.persist(users);
	}

	public void updateUser(Users users) {
		// TODO Auto-generated method stub
        entityManager.merge(users);
	}

	public List<Users> retriveAll() {
		// TODO Auto-generated method stub
        TypedQuery<Users> query = entityManager.createQuery("FROM Users", Users.class);
        return query.getResultList();
	}

	public List<Users> retriveById(Users user) {
		// TODO Auto-generated method stub
        TypedQuery<Users> query = entityManager.createQuery("FROM Users WHERE userId = :userId", Users.class);
        query.setParameter("userId", user.getUserId());
        List<Users> list = query.getResultList();
        return list.isEmpty() ? null : List.of(list.getFirst());
	}
}
