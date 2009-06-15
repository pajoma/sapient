package org.geospatial.kml.sugar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LookAt")
public class LookAt {
	
	@XStreamAlias("longitude")
	public String longitude;
	
	@XStreamAlias("latitude")
	public String latitude;
	
	@XStreamAlias("altitude")
	public String altitude;
	
	@XStreamAlias("altitudeMode")
	public String altitudeMode;
	
	@XStreamAlias("range")
	public String range;
	
	@XStreamAlias("tilt")
	public String tilt;
	
	@XStreamAlias("heading")
	public String heading;
}
