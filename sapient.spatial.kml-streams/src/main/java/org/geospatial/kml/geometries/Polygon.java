package org.geospatial.kml.geometries;


public class Polygon  extends KMLGeometry {

    private outerBoundaryIs outerBoundaryIs;
    private innerBoundaryIs innerBoundaryIs;

    public outerBoundaryIs getOuterBoundaryIs() {
        return outerBoundaryIs;
    }

    public void setOuterBoundaryIs(outerBoundaryIs outerBoundaryIs) {
        this.outerBoundaryIs = outerBoundaryIs;
    }

    public innerBoundaryIs getInnerBoundaryIs() {
        return innerBoundaryIs;
    }

    public void setInnerBoundaryIs(innerBoundaryIs innerBoundaryIs) {
        this.innerBoundaryIs = innerBoundaryIs;
    }
        
}
