package com.ibeacon.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ibeacon.beaconmanagement.domain.Beacon;


public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("temp");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		Beacon beacon = new Beacon("beacon",0,0,0,0,"t","test",new Date());
		
		em.persist(beacon);
		
		tx.commit();
		
		em.close();
		
	}

}
