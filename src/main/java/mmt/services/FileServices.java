package mmt.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mmt.datatype.Airport;
import mmt.datatype.Flight;

public class FileServices {


	private static String airportsCSV = "/airports.csv";
	private static String flightsCSV = "/flights.csv";

	public static Airport getAirport(String city) {
		Airport airport = new Airport();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(airportsCSV));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(cvsSplitBy);
				if(row[0].equals(city)) {
					airport.setCity(row[0]);
					airport.setLatitude(Double.parseDouble(row[1]));
					airport.setLongitude(Double.parseDouble(row[2]));
					airport.setState(row[3]);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return airport;

	}

	public static List<Airport> getAirports() {
		List<Airport> airportsList = new ArrayList<Airport>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(airportsCSV));
			while ((line = br.readLine()) != null) {
				Airport airport = new Airport();
				String[] row = line.split(cvsSplitBy);
				airport.setCity(row[0]);
				airport.setLatitude(Double.parseDouble(row[1]));
				airport.setLongitude(Double.parseDouble(row[2]));
				airport.setState(row[3]);
				airportsList.add(airport);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return airportsList;

	}

	public static List<Airport> getAirportsByState(String state) {
		List<Airport> airportsList = new ArrayList<Airport>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(airportsCSV));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(cvsSplitBy);
				if(row[1].equals(state)) {
					Airport airport = new Airport();
					airport.setCity(row[0]);
					airport.setLatitude(Double.parseDouble(row[1]));
					airport.setLongitude(Double.parseDouble(row[2]));
					airport.setState(row[3]);
					airportsList.add(airport);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return airportsList;

	}

	public static Flight getFlight(String flightNo) {
		Flight flight = new Flight();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(flightsCSV));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(cvsSplitBy);
				if(row[0].equals(flightNo)) {
					flight.setFlightNo(row[0]);
					flight.setFromCity(row[1]);
					flight.setToCity(row[2]);
					flight.setFromTime(row[3]);
					flight.setToTime(row[4]);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flight;

	}

	public static List<Flight> getFlights() {
		List<Flight> flightsList = new ArrayList<Flight>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(flightsCSV));
			while ((line = br.readLine()) != null) {
				Flight flight = new Flight();
				String[] row = line.split(cvsSplitBy);
				flight.setFlightNo(row[0]);
				flight.setFromCity(row[1]);
				flight.setToCity(row[2]);
				flight.setFromTime(row[3]);
				flight.setToTime(row[4]);
				flightsList.add(flight);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flightsList;

	}

	public static List<Flight> getFlightsByCity(String city) {
		List<Flight> flightsList = new ArrayList<Flight>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(flightsCSV));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(cvsSplitBy);
				if(row[1].equals(city) || row[2].equals(city)) {
					Flight flight = new Flight();
					flight.setFlightNo(row[0]);
					flight.setFromCity(row[1]);
					flight.setToCity(row[2]);
					flight.setFromTime(row[3]);
					flight.setToTime(row[4]);
					flightsList.add(flight);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flightsList;

	}

}
