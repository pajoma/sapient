package com.google.earth.kml;

import java.util.ArrayList;
import java.util.List;

public class innerBoundaryIs {

    private List <LinearRing> innerBoundaries = new ArrayList();

    public List<LinearRing> getInnerBoundaries() {
        return innerBoundaries;
    }

    public void setInnerBoundaries(List<LinearRing> innerBoundaries) {
        this.innerBoundaries = innerBoundaries;
    }
    
}
