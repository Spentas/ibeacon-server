package com.ibeacon.beaconmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ibeacon.beaconmanagement.dataaccess.BeaconDataAccess;
import com.ibeacon.beaconmanagement.dataaccess.BeaconNotFoundException;
import com.ibeacon.beaconmanagement.domain.Beacon;


	
	@Stateless
	public class BeaconManagementImplementation implements
			BeaconManagementServiceRemote, BeaconManagementServiceLocal {

		@EJB
		private BeaconDataAccess dao;

		public List<Beacon> getAllBeacon() 
		{
			return dao.findAll();
		}

		public void registerBeacon(Beacon newBeacon) {
			dao.insert(newBeacon);
		}

		public List<Beacon> searchByUUID(String UUID) {
			return dao.findByUUID(UUID);
		}

		
		public Beacon getBeaconById(int id) throws BeaconNotFoundException {
			return dao.findById(id);
		}

		
		public void deleteBeaconById(int id) throws BeaconNotFoundException {
			dao.deleteById(id);			
		}
		public void deleteAll(){
			dao.deleteAll();
		}

		
	}
