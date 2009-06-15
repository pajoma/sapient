package org.geospatial.kml.styles;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("IconStyle")
public class IconStyle extends Style {
	
	@XStreamAlias("scale")
	private String scale;
	
	@XStreamAlias("Icon")
	private Icon icon;
	
	@XStreamAlias("hotSpot")
	private String hotspot;
	
	@XStreamAlias("heading")
	private String heading;
	
	

}
