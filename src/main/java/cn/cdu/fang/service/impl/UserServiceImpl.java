package cn.cdu.fang.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Assert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService, Serializable{
	private static final long serialVersionUID = -2578927194612330917L;
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(User entity) {
		em.persist(entity);
	}
	@Override
	public void update(User entity) {
		em.merge(entity);
	}
	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(User.class,id));
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public User getEntity(Integer id) {
		return em.find(User.class, id);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getEntities() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getUserByEmail(String email) {
		Query query = em.createQuery("select u from User u where u.email=:email", User.class);
		query = query.setParameter("email", email);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getUserByName(String name) {
		Query query = em.createQuery("select u from User u where u.name=:name", User.class);
		query = query.setParameter("name", name);
		return query.getResultList();
	}
	
	
}