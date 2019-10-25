package com.capgemini.librarymanagement.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImplementation implements Validators{
	public Integer validateId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()) {
			return Integer.parseInt(id);
		}else {
			return null;
		}
	}

	@Override
	public String validateEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			return email;
		}else {
			return null;
		}
	}

	public String validatePassword(String password) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(password);
		if(mat.matches()) {
			return password;
		}else {
			return null;
		}
	}
}
