package com.wahyu.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wahyu.model.UserLogin;


@Component //supaya bisa dipakai oleh autowired
@Transactional // untuk auto rollback kalo gagal
@Repository
public class RegisterDAO {

	@Autowired
	SessionFactory sf;
	
	// CRUD : create read update delete
	public void add(UserLogin model)
	{
		//model.setId(UUID.randomUUID());
		sf.getCurrentSession().save(model);
	}
	
	/**
	 * Fungsi untuk ambil semua data user yang sudah register
	 * @return
	 */
	
	public List<UserLogin> get_all()
	{
		// hql : hibernate query language
		List<UserLogin> data = sf.getCurrentSession()
				.createQuery("from UserLogin").list();
		return data;
	}
	
	public void delete(int id)
	{
		UserLogin data = sf.getCurrentSession()
				.get(UserLogin.class, id);
		sf.getCurrentSession().delete(data);
	}
	
	public UserLogin get(int id)
	{
		UserLogin data = sf.getCurrentSession()
				.get(UserLogin.class , id);
		return data;
	}

	public void update(UserLogin dataBaru) {
		UserLogin dataLama = sf.getCurrentSession()
				.get(UserLogin.class, dataBaru.getId());
		
		dataLama.setEmail(dataBaru.getEmail());
		dataLama.setGender(dataBaru.getGender());
		dataLama.setStatus(dataBaru.getStatus());
		dataLama.setName(dataBaru.getName());
		
		sf.getCurrentSession().update(dataLama);
		
	}
}
