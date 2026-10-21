package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlacePayLoad;

public class testDataBuild {
	
	public addPlacePayLoad addPlaceAPIData(String name,String language,String address)
	{
		 Location l=new Location();
	        l.setLat(-38.383494);
	        l.setLng(33.427362);
	        
	        List<String> myList = new ArrayList<String>();
	        myList.add("shoe park");
	        myList.add("shop");
	        
		addPlacePayLoad app=new addPlacePayLoad();
		app.setAccuracy("50");
		app.setAddress(address);
		app.setLanguage(language);
		app.setName(name);
		app.setPhone_number("(+91) 983 893 3937");
		app.setWebsite("http://google.com");
		app.setLocation(l);
		app.setTypes(myList);
		return app;
	}

}
