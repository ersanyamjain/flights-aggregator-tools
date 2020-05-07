package mmt.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import mmt.services.MMTFlight;

@Path("/mmt")
@EnableAutoConfiguration
public class MMTRest {
	
	@Inject
	private MMTFlight mmtFlight;
	
	@Path("/flights/distance")
	@GET
	public Response calculateDistanceBetweenAirports(@PathParam("airport1") String airport1, @PathParam("airport2") String airport2) {
		System.out.println("calculateDistanceBetweenAirports");
		double distance = mmtFlight.getDistanceBetweenAirports(airport1, airport2);
		return Response.ok(distance).build();
	}
	
	@Path("/flights/airportlookup")
	@GET
	public Response findBestAirports (@PathParam("state") String state) {
		System.out.println("findAirports");
		mmtFlight.findBestAirports(state);
		return Response.ok("").build();
	}

}
