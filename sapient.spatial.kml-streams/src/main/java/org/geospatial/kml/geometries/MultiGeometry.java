package org.geospatial.kml.geometries;

import java.util.ArrayList;
import java.util.List;


public class MultiGeometry {
    
    private List<KMLGeometry> geometries = new ArrayList();

    public List<KMLGeometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<KMLGeometry> geometries) {
        this.geometries = geometries;
    }

}
