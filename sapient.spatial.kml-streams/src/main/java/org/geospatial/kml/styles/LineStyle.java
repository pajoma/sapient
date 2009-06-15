package org.geospatial.kml.styles;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LineStyle")
public class LineStyle extends Style {
	
	@XStreamAlias("color")
	private String color;
	
	@XStreamAlias("width")
	private String width;
	
	
}
