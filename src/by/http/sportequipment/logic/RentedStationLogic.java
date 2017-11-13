package by.http.sportequipment.logic;

import java.io.FileNotFoundException;

import by.http.sportequipment.station.RentedCatalog;

public interface RentedStationLogic {

	RentedCatalog readRentedCatalog() throws FileNotFoundException;

}
