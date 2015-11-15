package com.ibeacon.beaconmanagement;

import java.util.List;

import javax.ejb.Local;

import com.ibeacon.beaconmanagement.dataaccess.BeaconNotFoundException;
import com.ibeacon.beaconmanagement.domain.Beacon;

@Local
public interface BeaconManagementServiceLocal 
	{
		public void registerBeacon(Beacon newBeacon);
		public List<Beacon> getAllBeacon();
		public List<Beacon> searchByUUID(String UUID);
		public Beacon getBeaconById(int id) throws BeaconNotFoundException;
		public void deleteBeaconById(int id) throws BeaconNotFoundException;
		public void deleteAll();
	}

