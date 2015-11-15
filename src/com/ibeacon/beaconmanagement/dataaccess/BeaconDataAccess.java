package com.ibeacon.beaconmanagement.dataaccess;

import java.util.List;


import javax.ejb.Local;

import com.ibeacon.beaconmanagement.domain.Beacon;

@Local
public interface BeaconDataAccess {
public void insert(Beacon newbeacon);
public List<Beacon> findAll();
public List<Beacon> findByUUID(String UUID);
public Beacon findById(int id) throws BeaconNotFoundException;
public void deleteById(int id) throws BeaconNotFoundException;
public void deleteAll();

}
