package com.google.earth.kml;

import java.util.ArrayList;
import java.util.List;

public class Kml {
    
    private List<KmlFeature> features = new ArrayList();

    public List<KmlFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<KmlFeature> features) {
        this.features = features;
    }

}
