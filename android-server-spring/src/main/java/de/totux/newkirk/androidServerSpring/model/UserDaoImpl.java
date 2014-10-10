package de.totux.newkirk.androidServerSpring.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		List<User> userList = (List<User>)currentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return userList;
	}

	@Override
	public User get(int id) {
		String hql = "from USERS where id=" + id;
		Query query = currentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (!listUser.isEmpty() && listUser != null) {
			return listUser.get(0);
		}
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		currentSession().saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {
		User userToDelete = new User();
		userToDelete.setId(id);
		currentSession().delete(userToDelete);
	}

}
