package com.ibeacon.beaconmanagement.domain;

import java.io.Serializable;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Beacon implements Serializable
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String UUID;
	private int major;
	private int minor;
	private double Rssi;
	private int power;
	private String firmware;
	private String uinqueID;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Beacon(){	
	}
	
	public Beacon(String uUID, int major, int minor, double rssi, int power,
			String firmware, String uinqueID,Date date) {	
		super();
		this.date = date;
		this.UUID = uUID;
		this.major = major;
		this.minor = minor;
		this.Rssi = rssi;
		this.power = power;
		this.firmware = firmware;
		this.uinqueID = uinqueID;
	}
	
@Override
public String toString() {
	return "Beacon [UUID=" + UUID + ", major=" + major + ", minor=" + minor
			+ ", Rssi=" + Rssi + ", power=" + power + ", firmware=" + firmware
			+ ", uinqueID=" + uinqueID + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUUID() {
	return UUID;
}
public void setUUID(String uUID) {
	UUID = uUID;
}
public int getMajor() {
	return major;
}
public void setMajor(int major) {
	this.major = major;
}
public int getMinor() {
	return minor;
}
public void setMinor(int minor) {
	this.minor = minor;
}
public double getRssi() {
	return Rssi;
}
public void setRssi(double rssi) {
	Rssi = rssi;
}
public int getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}
public String getFirmware() {
	return firmware;
}
public void setFirmware(String firmware) {
	this.firmware = firmware;
}
public String getUinqueID() {
	return uinqueID;
}
public void setUinqueID(String uinqueID) {
	this.uinqueID = uinqueID;
}


}
