package com.ibeacon.backingbean;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.ibeacon.beaconmanagement.BeaconManagementServiceLocal;
import com.ibeacon.beaconmanagement.domain.Beacon;



@ManagedBean(name="allBeaconPageBean")
public class AllBeaconPageBean
{
	@EJB
	private BeaconManagementServiceLocal beaconService;
	private Beacon selectedBeacon;
	private UIData dataTable;	

	public List<Beacon> getAllBeacon()
	{
		return beaconService.getAllBeacon();
	}
	
	public String showBeacon()
	{
		this.selectedBeacon = (Beacon)dataTable.getRowData();
		
		return "beaconDetail";
	}
	
	public Beacon getSelectedBeacon() {
		return selectedBeacon;
	}

	public void setSelectedBeacon(Beacon selectedBeacon) {
		this.selectedBeacon = selectedBeacon;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public void deleteAllBeacon(){
		beaconService.deleteAll();
	}
}

