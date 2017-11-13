package by.http.sportequipment.logic;

import java.io.FileNotFoundException;

import by.http.sportequipment.station.Catalog;

public interface StationLogic {

	Catalog readCatalog() throws FileNotFoundException;

}
