package net.floodlightcontroller.sos.web;

import java.util.Collection;

import net.floodlightcontroller.sos.ISOSConnection;
import net.floodlightcontroller.sos.ISOSService;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatsTerminatedDetailsResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(StatsTerminatedDetailsResource.class);

	@Get
	public Collection<ISOSConnection> handleStatistics() {
		@SuppressWarnings("unchecked")
		Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers"); 
	    getResponse().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
	    if (responseHeaders == null) {
	    	responseHeaders = new Series<Header>(Header.class);
	    	getResponse().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, responseHeaders);
	    }
	    responseHeaders.add(new Header("Access-Control-Allow-Origin", "http://openflow.sites.clemson.edu")); 
		
		ISOSService sosService = (ISOSService) getContext().getAttributes().get(ISOSService.class.getCanonicalName());
		return sosService.getStatistics().getTerminatedConnections();
	}
}