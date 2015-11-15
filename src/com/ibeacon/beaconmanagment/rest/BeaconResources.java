package com.ibeacon.beaconmanagment.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.ServiceUnavailableException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ibeacon.beaconmanagement.BeaconManagementServiceLocal;
import com.ibeacon.beaconmanagement.dataaccess.BeaconNotFoundException;
import com.ibeacon.beaconmanagement.domain.Beacon;
@Path("/beacons")
@Stateless
public class BeaconResources {
	
	@EJB
	private BeaconManagementServiceLocal beaconManagement; 
	
	
	
	@GET
	@Produces("application/xml")
	public List<Beacon> getAllBeacons(){
	
		return beaconManagement.getAllBeacon();	
	
	}
	
	
	@GET
	@Produces("application/xml")
	@Path("{id}")
	public Beacon findBeaconById(@PathParam("id") String id){
		
		return new Beacon("tds",0,0,0,0,"","tdsf",new Date());
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEmployeeById(@PathParam("id") int id)
	{
		try
		{
		   beaconManagement.deleteBeaconById(id);
		   return Response.ok().build();
		}
		catch (BeaconNotFoundException e)
		{
			return Response.status(404).build();
		}
	}
	
//	@POST
//	@Produces("application/xml")
//	@Consumes("application/xml")
//	public Response createNewBeacon(Beacon beacon)
//	{
//		try
//		{
//		  beaconManagement.registerBeacon(beacon);
//		   return Response.ok().entity(beacon).build();
//		}
//		catch (Exception e)
//		{
//			return Response.status(Status.SERVICE_UNAVAILABLE).build();
//		}
//	}
	
	@POST
	@Produces("application/xml")
	@Consumes("application/xml")
	public Beacon createNewBeacon(Beacon beacon){
		try{
			beaconManagement.registerBeacon(beacon);
		}catch(Exception e){
			return null;
		}
		return beacon;
	}
	
//	@POST
//	@Produces("application/xml")
//	@Consumes("application/xml")
//	public List<Beacon> availableBeacon(List<Beacon> beacon){
//		try{
//			
//			//beaconManagement.registerBeacon(beacon);
//		}catch(Exception e){
//			return null;
//		}
//		return beacon;
//	}

}
