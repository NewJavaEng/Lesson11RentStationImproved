package by.http.sportequipment.command;

import by.http.sportequipment.command.impl.DefaultActionImpl;
import by.http.sportequipment.command.impl.ViewCatalogActionImpl;
import by.http.sportequipment.command.impl.ViewRentedCatalogActionImpl;

public class ActionHelper {

	public static StationAction defineAction(int input) {

		StationAction action = new DefaultActionImpl();
		switch (input) {
		case 1:
			action = new ViewCatalogActionImpl();
			break;
		case 3:
			action = new ViewRentedCatalogActionImpl();
			break;
		default:

		}
		return action;
	}

}
