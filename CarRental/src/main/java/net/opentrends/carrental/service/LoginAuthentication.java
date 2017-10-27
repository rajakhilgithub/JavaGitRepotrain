package net.opentrends.carrental.service;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthentication {
 public Boolean authenticate(String username,String password) {
	 if(username.equals("admin")&&password.equals("adm123")) {
		 return true;
	 }else {
		 return false;
	 }
 }
}
