package main.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.BaseTest;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static main.ApiConfigs.EndPoints.LogInEP.loginEP;
import static main.utils.Constants.appJson;
import static main.utils.Constants.xAuth;

public class CommonMethods {

    PropertyFilesReader propRead = new PropertyFilesReader();

    static final String COMMA_DELIMITER = ",";

    private String localDateTime;

    public static String screenshotPath;

    public static String screenshotName;

    public String getTokenInst() {
        String body = propRead.getUserCredentials();

        Response response = RestAssured.given()
                .contentType(appJson)
                .body(body)
                .post(loginEP);
        return response.body().jsonPath().get(xAuth).toString();
    }

    public String getServerURlIns() {
        return propRead.getServerURlProp();
    }

    public static String getTitle() {
        return BaseTest.driver.getTitle();
    }

    /**
     * Read CSV and Return the data in the form of List
     *
     * @return
     */
    public static List<List<String>> ReadCSV(String path) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return records;
    }

    /**
     * Gets the records from the CSV Line or Given Line
     *
     * @param line String of line with Comma Separator
     */
    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public String createScreenshotPath(String methodName){
        localDateTime = getLocalDateAndTimeString();
        screenshotName = methodName + localDateTime;
        screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots"  + File.separator + screenshotName;
        return screenshotPath;
    }

    public String getScreenshotName(){
        return screenshotPath;
    }

    public void TakeScreenshot(String methodName) {
        String fileName = createScreenshotPath(methodName);

        try {
            File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocalDateAndTimeString() {
        localDateTime = LocalDateTime.now().toLocalDate().toString() + "_" + LocalDateTime.now().toLocalTime().toString();
        localDateTime = localDateTime.replace(':', '_').replace('.', '_').replace('/', '_').replace('-', '_');
        return localDateTime;
    }

    public static List<String> getRecordFromCSV(String path, int lineNumber) {
        List<String> record = new ArrayList<>();
        int count = 1;
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                if (count == lineNumber) {
                    record = getRecordFromLine(scanner.nextLine());
                    break;
                } else
                    count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return record;
    }
}
