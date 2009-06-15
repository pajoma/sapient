package org.geospatial.kml;

import org.geospatial.kml.sugar.LookAt;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Document")
public class Document extends KMLContainer {
    

	
	@XStreamAlias("balloonVisibility")
	protected String ballonVisibility;
	
	

        
}
