package by.http.sportequipment.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.http.sportequipment.entity.Equipment;
import by.http.sportequipment.entity.RentUnit;
import by.http.sportequipment.station.Catalog;

public class FileStationLogicImpl implements StationLogic {

	private static final String FILE_PATH = "resources/station_info.txt";
	private static final String DELIMETER = ",";
	private static final int DEFAULT_CAPACITY = 10;

	@Override
	public Catalog readCatalog() throws FileNotFoundException {

		Catalog catalog = new Catalog();
		String[] lines = readData(FILE_PATH);

		for (String line : lines) {
			RentUnit unit = createRentUnit(line);
			catalog.addRentUnit(unit);
		}

		return catalog;
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
		// String [] values = null;

		// if (line!= null) {
		String[] values = line.split(DELIMETER);
		// }
		return values;
	}

	private String[] readData(String file) {

		int lastLineIndex = 0;
		// path to file
		// FileInputStream fis = new FileInputStream(file);
		// //αστεπ
		// BufferedInputStream bis = new BufferedInputStream(fis);
		String[] lines = new String[DEFAULT_CAPACITY];
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(FILE_PATH);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				// str = line.split(DELIMETER);

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

		// try {
		// int b;
		// while((b = fis.read()) != -1)
		// System.out.print((char)b);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// //TODO create proper catalog

		return trimDataToSize(lines, lastLineIndex);

	}

	private String[] increaseCapacity(String[] lines) {
		int currentLine = 0;
		String[] newLines = new String[lines.length + DEFAULT_CAPACITY];
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
