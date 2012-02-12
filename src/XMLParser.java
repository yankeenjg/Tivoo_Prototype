import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import java.util.ArrayList;

public class XMLParser {

	private String url;
	private ArrayList<Event> myEventList;
	
	XMLParser(String url){
		this.url = url;
	}
	
	public void parse(){
		try{
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(url);
			
			Element root = doc.getRootElement();
			
			BufferedWriter outputstream = new BufferedWriter(new FileWriter("test.txt"));
			
			/*Queue<Element> q = new LinkedList<Element>();
			q.add(root);
			while(!q.isEmpty()){
				Element current = q.remove();
				String toPrint = current.getText();
				if(toPrint!=null)
					System.out.println(toPrint);
				q.addAll(current.getChildren());
			}*/
			
			List<Element> eventsList = root.getChildren("event");
			myEventList = new ArrayList<Event>();
			for(Element event : eventsList){
				String eventName = event.getChildText("summary");		
				if(eventName.toLowerCase().contains("lemur") || eventName.toLowerCase().contains("lemurs"))
					continue;
				myEventList.add(new Event(eventName));
				outputstream.append(eventName + '\n');
			}
			
			//XMLOutputter out = new XMLOutputter();
			//out.output(doc, outputstream);
			outputstream.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Event> getEventList() {
		return myEventList;
	}
}


