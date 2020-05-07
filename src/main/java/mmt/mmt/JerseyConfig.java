package mmt.mmt;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import mmt.rest.MMTRest;

@Named
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(MMTRest.class);
	}
}
