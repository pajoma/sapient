package org.geospatial.kml.styles;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("StyleMap")
public class StyleMap {

	@XStreamAlias("Pair")
	@XStreamImplicit
	public List<Pair> pairs = new ArrayList<Pair>();
	
	
	@XStreamAlias("Pair")
	class Pair {
		@XStreamAlias("key")
		public String key;
		@XStreamAlias("styleUrl")
		public String styleUrl;
		
	}
}
