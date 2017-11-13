package by.http.sportequipment.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.http.sportequipment.entity.Equipment;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.station.RentedCatalog;

public class RentedFileStationLogicImpl implements RentedStationLogic {

	private static final String FILE_PATH_RENTED = "resources/rentedunit_info.txt";
	private static final String DELIMETER_RENTED = ",";
	private static final int DEFAULT_CAPACITY_RENTED = 10;

	@Override
	public RentedCatalog readRentedCatalog() throws FileNotFoundException {
		RentedCatalog rentedCatalog = new RentedCatalog();
		String[] lines = readData(FILE_PATH_RENTED);

		for (String line : lines) {
			RentUnit unit = createRentUnit(line);
			rentedCatalog.addRentUnit(unit);
		}

		return rentedCatalog;
	}

	private RentUnit createRentUnit(String line) {

		String[] values = getRentUnitValues(line);
		Equipment eq = new Equipment();
		eq.setTitle(values[0].trim());
		RentUnit unit = new RentUnit();
		unit.setEquipment(eq);
		unit.setHourRate(Double.parseDouble(values[1].trim()));

		return unit;
	}

	private String[] getRentUnitValues(String line) {

		String[] values = line.split(DELIMETER_RENTED);
		return values;
	}

	private String[] readData(String file) {

		int lastLineIndex = 0;
		String[] lines = new String[DEFAULT_CAPACITY_RENTED];
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(FILE_PATH_RENTED);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {

				if (lastLineIndex >= lines.length) {
					lines = increaseCapacity(lines);
				}
				lines[lastLineIndex] = line;
				lastLineIndex++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trimDataToSize(lines, lastLineIndex);

	}

	private String[] increaseCapacity(String[] lines) {
		int currentLine = 0;
		String[] newLines = new String[lines.length + DEFAULT_CAPACITY_RENTED];
		for (String line : lines) {
			newLines[currentLine] = line;
			currentLine++;
		}
		return newLines;

	}

	private String[] trimDataToSize(String[] lines, int linesCount) {
		int currentLine = 0;
		String[] trimedLines = new String[linesCount];
		for (String line : lines) {
			if (line != null) {
				trimedLines[currentLine] = line;
				currentLine++;
			}
		}
		return trimedLines;
	}

}
