package com.google.earth.kml;

public class Point implements KmlGeometry{
    
    private String coordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    
}
