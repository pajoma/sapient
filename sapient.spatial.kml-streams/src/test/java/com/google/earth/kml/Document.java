package com.google.earth.kml;

import java.util.ArrayList;
import java.util.List;

public class Document implements KmlFeature{
    
    private String name;
    private String address;
    private String description;
    private List<KmlFeature> features = new ArrayList();

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

    public List<KmlFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<KmlFeature> features) {
        this.features = features;
    }
        
}
