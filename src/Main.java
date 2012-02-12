
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		XMLParser xml = new XMLParser("http://www.cs.duke.edu/courses/cps108/current/assign/02_tivoo/data/dukecal.xml");
		xml.parse();
		ArrayList<Event> eventList = xml.getEventList();
		BasicHtmlOutput outputter = new BasicHtmlOutput();
		try {
			outputter.writeBasicOutput(eventList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
