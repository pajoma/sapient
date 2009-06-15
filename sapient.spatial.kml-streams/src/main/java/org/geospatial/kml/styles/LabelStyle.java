package org.geospatial.kml.styles;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LabelStyle")
public class LabelStyle extends Style {
	
	@XStreamAlias("scale")
	private String scale;

}
