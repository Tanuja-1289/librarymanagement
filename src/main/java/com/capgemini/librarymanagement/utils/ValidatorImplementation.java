package com.capgemini.librarymanagement.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidatorImplementation implements Validators{
	
	public Boolean validatePassword(String password) {
		Pattern pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,7})");
		Matcher mat = pat.matcher(password);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean validateName(String username) {
		Pattern pat = Pattern.compile("[a-zA-Z0-9]");
		Matcher mat = pat.matcher(username);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}
}
