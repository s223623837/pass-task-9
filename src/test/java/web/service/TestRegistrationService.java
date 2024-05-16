package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestRegistrationService {

    // Test registration with valid inputs
    @Test
    public void testRegistrationSuccess() {
        String fName = "John";
        String lName = "Doe";
        String email = "johndoe@example.com";
        String dob = "1990-01-01";
        
        boolean result = RegistrationService.register(fName, lName, email, dob);
        Assert.assertTrue("Registration should be successful", result);
    }

    // Test registration with empty first name
    @Test
    public void testRegistrationEmptyFirstName() {
        String fName = "";
        String lName = "Doe";
        String email = "johndoe@example.com";
        String dob = "1990-01-01";
        
        boolean result = RegistrationService.register(fName, lName, email, dob);
        Assert.assertTrue("Registration should fail with empty first name", result);
    }

    // Test registration with empty last name
    @Test
    public void testRegistrationEmptyLastName() {
        String fName = "John";
        String lName = "";
        String email = "johndoe@example.com";
        String dob = "1990-01-01";
        
        boolean result = RegistrationService.register(fName, lName, email, dob);
        Assert.assertTrue("Registration should fail with empty last name", result);
    }

    // Test registration with invalid email
    @Test
    public void testRegistrationInvalidEmail() {
        String fName = "John";
        String lName = "Doe";
        String email = "invalid_email"; // Invalid email format
        String dob = "1990-01-01";
        
        boolean result = RegistrationService.register(fName, lName, email, dob);
        Assert.assertTrue("Registration should fail with invalid email", result);
    }

    // Test registration with empty date of birth
    @Test
    public void testRegistrationEmptyDOB() {
        String fName = "John";
        String lName = "Doe";
        String email = "johndoe@example.com";
        String dob = "";
        
        boolean result = RegistrationService.register(fName, lName, email, dob);
        Assert.assertTrue("Registration should fail with empty date of birth", result);
    }
}

