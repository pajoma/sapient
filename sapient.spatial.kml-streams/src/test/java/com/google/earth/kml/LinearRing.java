package com.google.earth.kml;

public class LinearRing implements KmlGeometry{
    
    private String coordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
