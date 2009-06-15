package com.google.earth.kml;

import java.util.ArrayList;
import java.util.List;

public class Placemark implements KmlFeature{
    
    private String name;
    private String address;
    private String description;
    private List<KmlGeometry> geometries = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<KmlGeometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<KmlGeometry> geometries) {
        this.geometries = geometries;
    }
    
}
