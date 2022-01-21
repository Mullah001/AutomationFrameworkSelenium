package main.data.API;

import main.utils.CommonMethods;

import java.util.UUID;

public interface RegistrationData {

    /* Verify Email & Phone*/

    String validEmail = CommonMethods.generateRandomEmail();
    String validPhoneNumber = CommonMethods.generateRandomPhoneNumber();

    String invalidEmail = "hamza.ashfaq+2@synavos.com";
    String invalidPhoneNumber = "+923201234001";

    String emptyEmail = "";
    String emptyPhoneNumber = "";

    /* Register */

    String validName = "Hamza Ashfaq";
    String validPassword = "123456";

    String inValidName = "Hamza&*()Ashfaq";
    String inValidPassword = "12345";
    String inValidVerificationCode = UUID.randomUUID().toString();

    String emptyName = "";
    String emptyPassword = "";
    String emptyVerificationCode = "";

}
