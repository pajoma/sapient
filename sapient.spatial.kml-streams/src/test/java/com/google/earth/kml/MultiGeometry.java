package com.google.earth.kml;

import java.util.ArrayList;
import java.util.List;

public class MultiGeometry implements KmlGeometry{
    
    private List<KmlGeometry> geometries = new ArrayList();

    public List<KmlGeometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<KmlGeometry> geometries) {
        this.geometries = geometries;
    }
}
