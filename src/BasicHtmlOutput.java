import java.io.*;

import com.hp.gagawa.java.elements.*;
import java.util.*;

/*
 * Takes a list of events and outputs their names
 * in simple paragraph statements
 */

public class BasicHtmlOutput {

	public void writeBasicOutput(ArrayList<Event> eventList) throws IOException {
		Html head = new Html();
		Body body = new Body();
		head.appendChild(body);

		for (Event s : eventList) {
			P event = new P();
			event.appendChild(new Text(s.getEventName()));
			body.appendChild(event);
		}

		BufferedWriter out = new BufferedWriter(new FileWriter(
		"basic_output.html"));
		out.write(head.write());
		out.close();
	}
}
