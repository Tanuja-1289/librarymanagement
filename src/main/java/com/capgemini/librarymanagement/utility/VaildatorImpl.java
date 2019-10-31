package com.capgemini.librarymanagement.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class VaildatorImpl implements Validator {

	private Pattern pattern;
    private Matcher matcher;
	@Override
	 public boolean password(final String password) {
    	pattern = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})");
        matcher = pattern.matcher(password);
        return matcher.matches();
 
    }
    
	
    
	@Override
    public boolean email(final String email) {
    	pattern = Pattern.compile(" ^(.+)@(.+)$");
        matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
}
