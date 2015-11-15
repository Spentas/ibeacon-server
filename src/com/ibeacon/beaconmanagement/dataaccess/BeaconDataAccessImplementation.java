package com.ibeacon.beaconmanagement.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ibeacon.beaconmanagement.domain.Beacon;
@Stateless
public class BeaconDataAccessImplementation implements BeaconDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Beacon newBeacon) {	
	em.persist(newBeacon);
	}


	public List<Beacon> findAll() {
		Query q = em.createQuery("SELECT beacon from Beacon beacon");
		List list = q.getResultList();
		return list;
	}

	
	public List<Beacon> findByUUID(String UUID) {
		Query q = em.createQuery("select beacon from Beacon beacon where beacon.UUID= :UUId");
		q.setParameter("UUID", UUID);		
		return q.getResultList();
	}
	
	public Beacon findById(int id) throws BeaconNotFoundException
	{
		Beacon beacon = em.find(Beacon.class, id);
		if (beacon == null)
		{
			throw new BeaconNotFoundException();
		}
		
		return beacon;
	}

	public void deleteById(int id) throws BeaconNotFoundException
	{
		Beacon foundBeacon = findById(id);
		em.remove(foundBeacon);
	}
	public void deleteAll(){
		Query q = em.createQuery("DELETE from Beacon");
		q.executeUpdate();
				
	}

}
