package com.ibeacon.client;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ibeacon.beaconmanagement.BeaconManagementServiceRemote;
import com.ibeacon.beaconmanagement.domain.Beacon;


public class ClientApplicationTest {
	public static void main(String args[]){
	try {
	Context jndi = new InitialContext();
		
	BeaconManagementServiceRemote service = (BeaconManagementServiceRemote) jndi.lookup("com.ibeacon.beaconmanagement.BeaconManagementServiceRemote");
	service.registerBeacon(new Beacon("test1",0,0,0,0,"","test1",new Date()));
	service.registerBeacon(new Beacon("test2",0,0,0,0,"","test2",new Date()));
//	List<Beacon> beacon = service.getAllBeacon();	
//	for (Beacon next: beacon)	
//		System.out.println(next);		
	} catch(Exception e){		
		System.out.println( e);				
	}
	
	
	
	
	
	
	
}
}
