
package main.utils;
import org.testng.annotations.DataProvider;

public class DProvider extends CommonMethods{

    static String email = CommonMethods.generateRandomEmail();
    static String phoneNumber = CommonMethods.generateRandomPhoneNumber().replace("+92", "");

    @DataProvider(name = "signUpData")
    public static Object[][] signUpData(){
        Object[][] data = new Object[3][5];

        data[0][0] = "shameem.akhtar@synavos.com";
        data[0][1] = "1234567";
        data[0][2] = "Shameem";
        data[0][3] =  "+923456789009";
        data[0][4] = false;

        data[1][0] = "";
        data[1][1] = "";
        data[1][2] = "";
        data[1][3] =  "";
        data[1][4] = false;

        data[2][0] = email;
        data[2][1] = "1234567";
        data[2][2] = "Shameem";
        data[2][3] = phoneNumber;
        data[2][4] = true;

        return data;
    }

    @DataProvider(name = "signInData")
    public static Object[][] signInData(){
        Object[][] data = new Object[3][3];

        data[0][0] = "shameem";
        data[0][1] = "123456";
        data[0][2] = "inValid";

        data[1][0] = "";
        data[1][1] = "";
        data[1][2] = "empty";

        data[2][0] = "shameem.akhtar@synavos.com";
        data[2][1] = "12345678";
        data[2][2] = "valid";

        return data;
    }
//  Forget password login again
    String resetEmail = "shameem.akhtar@synavos.com";
    String emailPassword = "synavos@*19";
    String resetNewPassword = "12345678";
    String resetNewConfirmPassword = "12345678";

    public String getResetEmail(){
        return resetEmail;
    }

    public String getEmailPassword(){
        return emailPassword;
    }

    public String getResetNewPassword(){
        return resetNewPassword;
    }

    public String getResetNewConfirmPassword(){
        return resetNewConfirmPassword;
    }


//    Social Logins

    String googleEmail = "shameem.akhtar@synavos.com";
    String googlePasswrod = "synavos@*19";
    String facebookId = "tommyshelbyy88@gmail.com";
    String facebookPassword = "Peakyblinders12";

    public String getGoogleEmail(){
        return googleEmail;
    }

    public String getGooglePasswrod(){
        return googlePasswrod;
    }

    public String getFacebookId(){
        return facebookId;
    }

    public String getFacebookPassword(){
        return facebookPassword;
    }



}
