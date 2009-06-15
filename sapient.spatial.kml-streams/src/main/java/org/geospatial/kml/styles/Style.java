package org.geospatial.kml.styles;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Style")
public class Style {
	
	@XStreamAlias("IconStyle")
	private IconStyle iconStyle;
	
	@XStreamAlias("LineStyle")
	private LineStyle lineStyle;
	
	@XStreamAlias("LabelStyle")
	private LabelStyle labelStyle;
}
