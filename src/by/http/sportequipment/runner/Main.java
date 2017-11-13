package by.http.sportequipment.runner;

import java.io.IOException;

import by.http.sportequipment.command.ActionHelper;
import by.http.sportequipment.command.StationAction;
import by.http.sportequipment.view.ConsoleMenu;

public class Main {

	public static void main(String[] args) throws IOException {
		ConsoleMenu.printMenu();
		int input = ConsoleMenu.readUserInput();

		// StationAction action - ссылка на интерфейс

		StationAction action = ActionHelper.defineAction(input);
		action.performAction();

	}

}
