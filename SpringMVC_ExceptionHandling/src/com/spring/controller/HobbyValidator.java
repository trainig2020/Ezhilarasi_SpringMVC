package com.spring.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
	
	private String listOfHobbies;
	 @Override
	    public void initialize(IsValidHobby isValidHobby) {
		 this.listOfHobbies = isValidHobby.listOfHobbies();

	    }

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		if(studentHobby==null){
			return false;
		}
		/*else if(studentHobby.matches("Music|Dance|Sports")){*/
		else if(studentHobby.matches(listOfHobbies)){
			return true;
		}
		else{
			return false;
		}
		
	}

}
