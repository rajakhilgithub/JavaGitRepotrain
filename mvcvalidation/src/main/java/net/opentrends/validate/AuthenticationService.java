package net.opentrends.validate;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
@Autowired
private Loginmap lmap;
	public boolean authenticate(String uname,String pass) {
		Iterator<String> iterator=lmap.getLogmap().keySet().iterator();
		while(iterator.hasNext()) {
			String akey=iterator.next();
			String avalue=lmap.getLogmap().get(akey);
			if(akey.equals(uname)&&avalue.equals(pass))
				return true;
		}
		
			return false;
	}

}
