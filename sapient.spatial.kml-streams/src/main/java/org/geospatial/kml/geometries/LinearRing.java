package org.geospatial.kml.geometries;

import java.util.List;

import sapient.features.streams.kml.converter.CoordinateConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;


/**
 * The Linear Ring is a Line String where the first and last points are the same 
 * @author pajoma
 *
 */
@XStreamAlias("LinearRing")
public class LinearRing extends LineString {
    
		
}
