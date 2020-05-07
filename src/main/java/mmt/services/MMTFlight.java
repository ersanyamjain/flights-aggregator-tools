package mmt.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Named;
import mmt.datatype.Airport;
import mmt.datatype.Flight;

@Named
public class MMTFlight {

	public void findBestAirports(String state) {

		List<Airport> airportsList = FileServices.getAirportsByState(state);

		for(Airport airport: airportsList) {
			Map<String, Double> map = new HashMap<String, Double>();
			Map<String, Integer> mapFlightsCount = new HashMap<String, Integer>();

			for(Airport airport1: airportsList) {
				if(!airport.getCity().equals(airport1.getCity())) {
					double distance = getDistanceBetweenAirports(airport, airport1);
					map.put(airport1.getCity(), distance);
				}

			}

			List<Flight> flightsList = FileServices.getFlightsByCity(airport.getCity());
			mapFlightsCount.put(airport.getCity(), flightsList.size());

			LinkedHashMap<String, Double> sortedMap = sortHashMapByValues((HashMap<String, Double>) map);
			List<Entry<String,Double>> entryList = new ArrayList<Map.Entry<String,Double>>(map.entrySet());

			LinkedHashMap<String, Integer> sortedFlightsMap = sortHashMapByFlightsCount((HashMap<String, Integer>) mapFlightsCount);
			List<Entry<String,Integer>> entryList1 = new ArrayList<Map.Entry<String,Integer>>(sortedFlightsMap.entrySet());

			if(sortedMap.size() > 1) {
				System.out.println("Airport: "+ airport.getCity()+" 2 Nearest Airports: ["
						+ entryList.get(entryList.size()-1).getKey() + ", " + entryList.get(entryList.size()-2).getKey() + "]");

			} else if(sortedMap.size() == 1) {
				System.out.println("Airport: "+ airport.getCity()+" 1 Nearest Airport: [" + entryList.get(entryList.size()-1).getKey() + "]");
			}  else {
				System.out.println("Airport: "+ airport.getCity()+" No nearest airports");
			}

			if(sortedFlightsMap.size() > 1) {
				System.out.println("Airport: "+ airport.getCity()+" 2 Max Flights Airports: ["
						+ entryList1.get(entryList1.size()-1).getKey() + ", " + entryList1.get(entryList1.size()-2).getKey() + "]");

			} else if(sortedFlightsMap.size() == 1) {
				System.out.println("Airport: "+ airport.getCity()+" 1 Max Flights Airport: [" + entryList1.get(entryList1.size()-1).getKey() + "]");
			}  else {
				System.out.println("Airport: "+ airport.getCity()+" No Max Flights airports");
			}
		}
	}

	public LinkedHashMap<String, Double> sortHashMapByValues(HashMap<String, Double> passedMap) {
		List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
		List<Double> mapValues = new ArrayList<Double>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();

		Iterator<Double> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Double val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				Double comp1 = passedMap.get(key);
				Double comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}

	public LinkedHashMap<String, Integer> sortHashMapByFlightsCount(HashMap<String, Integer> passedMap) {
		List<String> mapKeys = new ArrayList<String>(passedMap.keySet());
		List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Integer val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				Integer comp1 = passedMap.get(key);
				Integer comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}

	public double getDistanceBetweenAirports(Airport airportObj1, Airport airportObj2) {
		double distance = getDistanceFromLatLonInKm(airportObj1.getLatitude(), airportObj1.getLongitude(), airportObj2.getLatitude(), airportObj2.getLongitude());
		System.out.println("Distance: "+distance);
		return distance;
	}

	public double getDistanceBetweenAirports(String airport1, String airport2) {
		Airport airportObj1 = FileServices.getAirport(airport1);
		Airport airportObj2 = FileServices.getAirport(airport2);
		double distance = getDistanceFromLatLonInKm(airportObj1.getLatitude(), airportObj1.getLongitude(), airportObj2.getLatitude(), airportObj2.getLongitude());
		System.out.println("Distance: "+distance);
		return distance;
	}

	private double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371; 
		double dLat = deg2rad(lat2 - lat1);  
		double dLon = deg2rad(lon2 - lon1); 
		double a = (long) (Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2)); 
		double c = (long) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))); 
		return R * c;
	}

	private double deg2rad(double deg) {
		return (long) (deg * (Math.PI/180));
	}


}
