package net.floodlightcontroller.sos.web;

import java.util.HashMap;
import java.util.Map;

import net.floodlightcontroller.sos.ISOSService;
import net.floodlightcontroller.sos.ISOSStatistics;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatsResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(StatsResource.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Get
	public ISOSStatistics handleStatistics() {
		Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers"); 
	    getResponse().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
	    if (responseHeaders == null) {
	    	responseHeaders = new Series(Header.class);
	    	getResponse().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, responseHeaders);
	    }
	    responseHeaders.add(new Header("Access-Control-Allow-Origin", "http://openflow.sites.clemson.edu")); 
		
		ISOSService sosService = (ISOSService) getContext().getAttributes().get(ISOSService.class.getCanonicalName());
		return sosService.getStatistics();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Delete
	public Map<String, String> clearStatistics() {
		Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers"); 
	    getResponse().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
	    if (responseHeaders == null) {
	    	responseHeaders = new Series(Header.class);
	    	getResponse().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, responseHeaders);
	    }
	    responseHeaders.add(new Header("Access-Control-Allow-Origin", "http://openflow.sites.clemson.edu")); 
		
		ISOSService sosService = (ISOSService) getContext().getAttributes().get(ISOSService.class.getCanonicalName());
		
		Map<String, String> ret = new HashMap<String, String>();
		
		switch (sosService.clearStatistics()) {
		case STATS_CLEARED:
			ret.put(Code.CODE, Code.OKAY);
			ret.put(Code.MESSAGE, "Statistics cleared");
			break;
		default:
			ret.put(Code.CODE, Code.ERR_BAD_ERR_CODE);
			ret.put(Code.MESSAGE, "Received improper SOS error code");
			break;
		}
		return ret;
	}
}