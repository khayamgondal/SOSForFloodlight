package net.floodlightcontroller.sos.web;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.floodlightcontroller.sos.ISOSConnection;
import net.floodlightcontroller.sos.ISOSService;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatsTerminatedListResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(StatsTerminatedListResource.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Get
	public Collection<UUID> handleStatistics() {
		Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers"); 
	    getResponse().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
	    if (responseHeaders == null) {
	    	responseHeaders = new Series(Header.class);
	    	getResponse().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, responseHeaders);
	    }
	    responseHeaders.add(new Header("Access-Control-Allow-Origin", "http://openflow.sites.clemson.edu")); 
		ISOSService sosService = (ISOSService) getContext().getAttributes().get(ISOSService.class.getCanonicalName());
		
		Set<UUID> transfers = new HashSet<UUID>();
		for (ISOSConnection conn : sosService.getStatistics().getTerminatedConnections()) {
			transfers.add(conn.getTransferID());
		}
		return transfers;
	}
}