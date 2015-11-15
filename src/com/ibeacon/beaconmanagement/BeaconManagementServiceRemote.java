package com.ibeacon.beaconmanagement;

import java.util.List;

import javax.ejb.Remote;

import com.ibeacon.beaconmanagement.dataaccess.BeaconNotFoundException;
import com.ibeacon.beaconmanagement.domain.Beacon;

@Remote
public interface BeaconManagementServiceRemote {
		public void registerBeacon(Beacon newBeacon);
		public List<Beacon> getAllBeacon();
		public List<Beacon> searchByUUID(String UUID);
		public Beacon getBeaconById(int id) throws BeaconNotFoundException;
		public void deleteBeaconById(int id) throws BeaconNotFoundException;	
		public void deleteAll();

}
