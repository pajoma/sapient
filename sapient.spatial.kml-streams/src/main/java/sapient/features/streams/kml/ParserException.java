package sapient.features.streams.kml;

import java.io.IOException;

public class ParserException extends IOException {

	private final String string;

	public ParserException(String string) {
		this.string = string;
	}
	
	public String getMessage() {
		return string;
	}

}
