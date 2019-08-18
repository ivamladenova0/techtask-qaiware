package dataproviders;

import org.testng.annotations.DataProvider;
import utils.ExcelReader;
import java.io.IOException;

public class DataProviders {

    ExcelReader excelReader;
    private static String user_tests_file_location = System.getProperty("user.dir") + "/src/test/resources/data/users-test-scenarios.xls";
    private static String register_tests_file_location = System.getProperty("user.dir") + "/src/test/resources/data/register_test_scenarios.xls";

   @DataProvider(name = "register-negative-cases")
    public Object[][] getRegisterNegativeData() throws IOException {
        String sheetName = "Register user - negative";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(register_tests_file_location, sheetName);
        return Data;
    }

    @DataProvider(name = "register-positive-cases")
    public Object[][] getRegisterPositiveData() throws IOException {
        String sheetName = "Register user - positive";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(register_tests_file_location, sheetName);
        return Data;
    }

    @DataProvider(name = "get-single-user-positive")
    public Object[][] getSingleUserPositiveCaseData() throws IOException {
        String sheetName = "Get single user - positive";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(user_tests_file_location, sheetName);
        return Data;
    }

    @DataProvider(name = "get-single-user-negative")
    public Object[][] getSingleUserNegativeCaseData() throws IOException {
        String sheetName = "Get single user - negative";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(user_tests_file_location, sheetName);
        return Data;
    }

    @DataProvider(name = "create-new-user")
    public Object[][] getCreateUserPositiveData() throws IOException {
        String sheetName = "Create new user";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(user_tests_file_location, sheetName);
        return Data;
    }

    @DataProvider(name = "delete-user")
    public Object[][] getDeleteUserData() throws IOException {
        String sheetName = "Delete user";
        excelReader = new ExcelReader();
        Object Data[][] =  excelReader.ReadExcelSheet(user_tests_file_location, sheetName);
        return Data;
    }
}