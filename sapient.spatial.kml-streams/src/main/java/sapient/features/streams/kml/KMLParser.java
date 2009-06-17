package sapient.features.streams.kml;

 import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.geospatial.kml.KML;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;



public class KMLParser {
	
	
	
	private KML kml;

	public KML start(URL url) throws IOException {
		File f = new KMLRetriever().fetch(url);
		return this.start(new FileInputStream(f));		
	}

	public KML start(File f) throws IOException {
		return this.start(f.toURI().toURL());
	}
	
	
	public KML start(InputStream in) {
		try {
			QNameMap qnameMap = new QNameMap();
			qnameMap.setDefaultNamespace("http://www.opengis.net/kml/2.2");
			XStream xstream = new XStream(new StaxDriver(qnameMap));
			new XStreamsConfiguration().configure(xstream);
			 kml = (KML) xstream.fromXML(in);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			IOUtils.closeQuietly(in);
		}
		return kml;

	}
	
	



	
}
