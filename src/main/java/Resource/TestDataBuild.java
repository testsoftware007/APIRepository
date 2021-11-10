package Resource;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlace(String name, String language, String address)
	{
		
		AddPlace o = new AddPlace();
		o.setAccuracy(23);
    	o.setAddress(address);
    	o.setLanguage(language);
    	Location l = new Location();
    	l.setLat(23);
    	l.setLng(33);
    	o.setLocation(l);
    	o.setName(name);
    	o.setPhone_number("7777777717");
    	o.setWebsite("test.com");
    	List<String> mylist = new ArrayList<>();
    	mylist.add("Hello");
    	mylist.add("Mike");
    	o.setTypes(mylist);
    	
    	return o;
	}

}
