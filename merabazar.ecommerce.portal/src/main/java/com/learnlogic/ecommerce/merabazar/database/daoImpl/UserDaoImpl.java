package com.learnlogic.ecommerce.merabazar.database.daoImpl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;






import com.learnlogic.ecommerce.merabazar.database.dao.UserDao;
import com.learnlogic.ecommerce.merabazar.model.Users;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
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
        TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u", Users.class);
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Users> retriveById(Users user) {
		// TODO Auto-generated method stub
        TypedQuery<Users> query = entityManager.createQuery(
            "SELECT u FROM Users u WHERE u.userId = :userId", Users.class);
        query.setParameter("userId", user.getUserId());
        List<Users> list = query.getResultList();
        return list.isEmpty() ? null : List.of(list.getFirst());
	}
}
