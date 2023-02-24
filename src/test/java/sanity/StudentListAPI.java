package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class StudentListAPI extends CommonOps {

    @Test(description = "Test 01: Get Students From StudentsList")
    @Description("This Test Verify Students Property")
    public void test01_verifyList(){
        Verifications.verifyText(ApiFlows.getStudentsProperty("[0].firstName"), "Vernon");
    }

    @Test(description = "Test 02: Add New Student And Verify")
    @Description("This Test Adds a Student to StudentsList and Verify it")
    public void test02_addStudentAndVerify(){
        ApiFlows.postStudent("Sveta", "Fomin", "fomin.svet@gmail.com","Computer Science",
                "Calculus",
                "Algorithms",
                "Software Development");
        Verifications.verifyText(ApiFlows.getStudentsProperty("[100].lastName"), "Fomin");
    }

    @Test(description = "Test 03: Update Student And Verify")
    @Description("This Test Updates a Student in StudentsList and Verify it")
    public void test03_updateStudentAndVerify(){
        String id = ApiFlows.getStudentsProperty("[2].id");
        ApiFlows.putStudent(id,"New", "HarperNew", "vernon.new@gmail.com","Computer Science",
                "Calculus",
                "Algorithms",
                "Software Development");
        Verifications.verifyText(ApiFlows.getStudentsProperty("[2].lastName"), "HarperNew");
    }

    @Test(description = "Test 04: Delete Student And Verify")
    @Description("This Test Deletes a Student from StudentsList and Verify it")
    public void test04_deleteStudentAndVerify(){
        String id = ApiFlows.getStudentsProperty("[0].id");
        ApiFlows.deleteStudent(id);
        Verifications.verifyText(ApiFlows.getStudentsProperty("[0].firstName"), "Murphy");
        Verifications.verifyText(ApiFlows.totalCount(),"100");
    }
}
