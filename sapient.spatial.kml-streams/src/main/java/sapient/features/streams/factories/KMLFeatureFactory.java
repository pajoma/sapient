package sapient.features.streams.factories;

import java.util.List;

import org.geospatial.kml.Placemark;
import org.geospatial.kml.geometries.KMLGeometry;
import org.geospatial.kml.geometries.LineString;
import org.geospatial.kml.geometries.LinearRing;
import org.geospatial.kml.geometries.Point;

import sapient.annotations.factory.AnnotationsFactory;
import sapient.annotations.model.Description;
import sapient.annotations.model.contact.Address;
import sapient.annotations.model.contact.Name;
import sapient.features.Feature;
import sapient.features.factories.FeatureFactory;
import sapient.features.factories.GeometryFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class KMLFeatureFactory extends FeatureFactory {

	private GeometryFactory geomFactory;
	private AnnotationsFactory annotFactory;

	public KMLFeatureFactory() {
		geomFactory = getGeometryFactory(4326);
		annotFactory = new AnnotationsFactory();
	}


	@Override
	public Feature createFeature() {
		return new Feature(){
			
		};
	}
	
	public Feature createFeature(Placemark p) {
		Feature f = createFeature();
		Address annot_address = annotFactory.createAddress(f, p.getAddress());
		Name annot_name = annotFactory.createName(f, p.getName());
		Description annot_desc = annotFactory.createDescription(f, p.getDescription());
		
		f.addAnnotation(annot_address);
		f.addAnnotation(annot_name);
		f.addAnnotation(annot_desc);

		f.setGeometry(this.renderGeometry(p.listGeometries()));
		return f;
	}
	

	private Geometry renderGeometry(List<? extends KMLGeometry> listGeometries) {
		for(KMLGeometry kgeo : listGeometries) {
			List<Coordinate> coords = kgeo.listCoordinates();
	
			if(kgeo instanceof Point) 
				return geomFactory.createPoint(((Point) kgeo).getCoordinate());
			
			if(kgeo instanceof LineString) 
				return geomFactory.createLineString(coords.toArray(new Coordinate[] {}));
			
			if(kgeo instanceof LinearRing) 
				return geomFactory.createLinearRing(coords.toArray(new Coordinate[] {}));
			
//			if(kgeo instanceof Polygon) 
//				return geomFactory.createP(coords.toArray(new Coordinate[] {}));
		}
		
		return null;
	}


}

