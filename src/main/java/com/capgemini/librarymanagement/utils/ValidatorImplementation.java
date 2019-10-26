package com.capgemini.librarymanagement.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidatorImplementation implements Validators{
	public Boolean validateId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean validateEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}

	public Boolean validatePassword(String password) {
		Pattern pat = Pattern.compile("((?=*");
		Matcher mat = pat.matcher(password);
		if(mat.matches()) {
			return true;
		}else {
			return false;
		}
	}
}
