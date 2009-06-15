package sapient.features.streams.kml;

 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.geospatial.kml.*;
import org.geospatial.kml.geometries.*;
import org.geospatial.kml.styles.*;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;



public class KMLParser {
	
	
	
	private KML kml;



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
	
	private void registerAnnotations(XStream xstream) throws InstantiationException, IllegalAccessException {
		xstream.processAnnotations(KML.class);
		
		
		xstream.processAnnotations(Placemark.class);
		
		// we add the geometries manually
		
		// xstream.addImplicitCollection(Placemark.class, "geometries", Point.class);
		
		xstream.processAnnotations(Document.class);
		xstream.processAnnotations(Folder.class);
		xstream.processAnnotations(KMLContainer.class);
		xstream.processAnnotations(KMLFeature.class);
		xstream.processAnnotations(KMLGeometry.class);
		xstream.processAnnotations(Style.class);

		xstream.processAnnotations(LineString.class);
		xstream.processAnnotations(Point.class);
			
		
	}


	public KML start(URL url) throws IOException {
		File f = getCachedFile(url);
		return this.start(new FileInputStream(f));		
	}


	private File getCachedFile(URL url) throws IOException {
		StringBuffer pre = new StringBuffer(System.getProperty("java.io.tmpdir")); 
		if ( !(pre.toString().endsWith("/") || pre.toString().endsWith("\\")) ) pre.append(System.getProperty("file.separator"));
		pre.append("cached");
		pre.append(url.hashCode());
		
		File kml = new File(pre.toString()+".kml");

		if(kml.createNewFile()) {
			
			
			InputStream in = null;
			OutputStream out = null;
			try {
				if(getSuffix(url) == ".kmz") in = extractSource(url, "doc.kml"); 
				else in = url.openConnection().getInputStream();
				out = new FileOutputStream(kml);
				IOUtils.copy(in, out);
			} catch (IOException e) {
				throw e;
			} finally {
				IOUtils.closeQuietly(in);
				IOUtils.closeQuietly(out);
			}
		}
		return kml;
	}
	
	/**
	 * If the resource is hidden in a ZIP file, download, cache, and extract resource
	 * 
	 * @param url
	 * @return the input stream with the given source
	 * @throws IOException 
	 */
	private InputStream extractSource(URL url, String entry) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {

			File f = File.createTempFile("zippedSource", ".zip");
			out = new FileOutputStream(f);
			in = url.openStream();
			
			IOUtils.copy(in, out);
			ZipFile zip = new ZipFile(f);
			ZipEntry ze = zip.getEntry(entry);
			return zip.getInputStream(ze);
			
		} catch (IOException e) {
			throw e;
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		
		
		
	}
	
	
	
	/**
	 * Checks if .KML or .KMZ appears somewhere in path 
	 * 
	 * @param url
	 * @throws ParserException 
	 * @throws MareDefinedException
	 */
	private String getSuffix(URL url) throws ParserException {
		if(url.getFile().endsWith(".kml")) return ".kml";
		else if(url.getFile().endsWith(".kmz")) return ".kmz";
		else throw new ParserException("validation.file.unsupported");
	}
}
