package sapient.features.streams.kml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

import sapient.features.streams.exceptions.ParserException;

public class KMLRetriever {

	
	/**
	 * Tries to fetch a KML file from the given URL. If it points to a zipped KML, it will
	 * be extracted. Makes use of caching.
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public File fetch(URL url) throws IOException {
		StringBuffer pre = new StringBuffer(System.getProperty("java.io.tmpdir")); 
		if ( !(pre.toString().endsWith("/") || pre.toString().endsWith("\\")) ) pre.append(System.getProperty("file.separator"));
		pre.append("cached");
		pre.append(url.hashCode());
		
		File kml = new File(pre.toString()+".kml");

		if(kml.createNewFile()) {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = fetchStream(url);
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
	 * Directly returns the input stream coming from the URL (or the zipped
	 * KML). Does not cache. 
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public InputStream fetchStream(URL url) throws IOException {
		InputStream in = null;
		
		if(getSuffix(url) == ".kmz") in = extractSource(url, "doc.kml"); 
		else in = url.openConnection().getInputStream();
		
		return in;
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
