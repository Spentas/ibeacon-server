package com.ibeacon.beaconmanagment.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ibeacon.beaconmanagement.BeaconManagementServiceLocal;
import com.ibeacon.beaconmanagement.domain.Beacon;

@Path("/registerbeacon")
public class AndroidClient {
	
	@EJB
	BeaconManagementServiceLocal beaconManagment;
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 	
	public String registerBeacon(@QueryParam("uuid")String uuid, @QueryParam("uniqueid") String uniqueid, @QueryParam("major") String major,@QueryParam("minor") String minor
			,@QueryParam("txpower") int txpower,@QueryParam("firmware") String firmware,@QueryParam("time") String time){
		
		String response = "";		
		beaconManagment.registerBeacon(new Beacon(uuid,Integer.parseInt(major),Integer.parseInt(minor),0.0,txpower,"null",uniqueid,getDate(time)));		
		return response;
				
	}
	
	private Date getDate(String dateString) {
	    try {
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	        Date date = df.parse(dateString);
	        return date;
	    } catch (ParseException e) {
	        //WebApplicationException ...("Date format should be yyyy-MM-dd'T'HH:mm:ss", Status.BAD_REQUEST);
	   return null;
	    }
	}
}
