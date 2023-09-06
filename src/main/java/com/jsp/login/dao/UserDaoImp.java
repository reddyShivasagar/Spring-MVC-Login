package com.jsp.login.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsp.login.model.UserModel;

@Repository
public class UserDaoImp {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sagar");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public String deleteUser(int id) {
		
		UserModel userModel=entityManager.find(UserModel.class,id);
		
		entityTransaction.begin();
		entityManager.remove(userModel);
		entityTransaction.commit();
		return "Deleted";
	}
	
	
	public String saveUser(UserModel userModel) {
		entityTransaction.begin();
		entityManager.persist(userModel);
		entityTransaction.commit();
		return userModel.getName()+" is saved";
	}
	
	public ArrayList<UserModel> getAllUser() {
		
		Query q=entityManager.createQuery("select u from UserModel u");
		return (ArrayList<UserModel>) q.getResultList();
	}
}
