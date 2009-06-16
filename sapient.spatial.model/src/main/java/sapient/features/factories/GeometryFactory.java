package sapient.features.factories;

import com.vividsolutions.jts.geom.PrecisionModel;

public class GeometryFactory extends com.vividsolutions.jts.geom.GeometryFactory {

	public GeometryFactory(PrecisionModel pm, int srs) {
		super(pm,srs);
	}
	
	public GeometryFactory() {
		// we don't allow no specification of a srs, set default to epsg:4362
		super(new PrecisionModel(PrecisionModel.FLOATING),4326);
	}
	
	
	
	

}
