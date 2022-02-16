package main.data.API;

import groovy.lang.GString;

public interface LogInData {
    /******** LogIn - Consumer *******/

    /* Valid Data*/
    String email = "hamza.ashfaq@synavos.com";
    String password = "123456";

    /* InValid Data*/
    String inValidEmail = "hamza.ashfa@synavos.com";
    String inValidPassword = "12345";

    /* Empty Data*/
    String emptyEmail = "";
    String emptyPassword = "";

    /************** Log In - Admin ***************/

    String userName_Admin = "master";
    String password_Admin = "123456";


    /******* Log In With Google ******/

    String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjMzZmY1YWYxMmQ3NjY2YzU4Zjk5NTZlNjVlNDZjOWMwMmVmOGU3NDIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiOTUxNjc0MjQ0ODMtYWlkdXJ1am8yZG80M2duMzVsdWI0OGNnN21pYTRhcjAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI5NTE2NzQyNDQ4My1haWR1cnVqbzJkbzQzZ24zNWx1YjQ4Y2c3bWlhNGFyMC5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExMTM2NDk2MzkxNDM3NDgyNzgzMSIsImhkIjoic3luYXZvcy5jb20iLCJlbWFpbCI6ImhhbXphLmFzaGZhcUBzeW5hdm9zLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiYU5iTGJZWlI2djMwcUtfUzVDRm9fQSIsIm5hbWUiOiJIYW16YSBBc2hmYXEiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFUWEFKeHpqdzl5NDhHSVkwTHNCQW80RU1CdVJDdVduV19TRnlxcXNVYz1zOTYtYyIsImdpdmVuX25hbWUiOiJIYW16YSAiLCJmYW1pbHlfbmFtZSI6IkFzaGZhcSIsImxvY2FsZSI6ImVuIiwiaWF0IjoxNjQxOTc5NDc3LCJleHAiOjE2NDE5ODMwNzcsImp0aSI6IjU4Njc1ZDFjZjRkNTNlYjhjYTUzMjUxMzg1ZmQyZWEwYWQ2NDkxZGMifQ.lCPDHAfD0eeWjkJz8tG9eEo3rabGYMTGU2ytRyZid1j1fR0bHYjQdiv8mP6ZfKY2_IXF1zMk84YjW9duI44XMvFTS-ufRKHx1iupqAo4BlncilxvR0cnf7NLWGjjeA5kscHMcQYeYuIVQEKtT0cgA8v5YlLBawmagKDNfCCHLPcpbkOsnKyIsnD4Dy0iqucKUyQU_OipOFktVsw812YClrU5SDuJ1dKC9kddAMJBO7HBSVGMvsFWEk50xJgs_5Cm29VzvhG8kZGyNtn5c7shf5qf4fjnK1Bc8Z8qYXHSJCj6w49DZD-TyIoaJIE2S1OkJFi-8ucCGOVXnbCnZulMEg";
    String CLIENT_ID = "95167424483-aidurujo2do43gn35lub48cg7mia4ar0.apps.googleusercontent.com";

    /********* Forgot Password ******/

    /* Valid Data*/
    String forgotEmail = "hamza.ashfaq@synavos.com";

    /* InValid Data*/
    String inValidForgotEmail = "hamza.ashfa@synavos.com";

    /* Empty Data*/
    String emptyForgotEmail = "";


    /******** Resave Password **********/

    /* Valid Data*/
    String resetToken = "1641885928355";
    String new_password = "123456";

    /* InValid Data*/
    String inValidResetToken = "164188592835512431234";

    /* Empty Data*/
    String emptyResetToken = "";
    //emptyPassword




}
