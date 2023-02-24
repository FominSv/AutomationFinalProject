package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.Arrays;


public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Students Property")
    public static String getStudentsProperty(String jPath){
        response = APIActions.get("/student/list");
        return APIActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Student in StudentsList")
    public static void postStudent(String first_name, String last_name, String email,  String programme, String course1, String course2, String course3){
        params.put("firstName",first_name);
        params.put("lastName",last_name);
        params.put("email",email);
        params.put("programme",programme);
        params.put("courses", Arrays.asList(course1, course2, course3));
        APIActions.post(params, "/student");
    }

    @Step("Business Flow: Update Existing Student in StudentsList")
    public static void putStudent(String id, String first_name, String last_name, String email,  String programme, String course1, String course2, String course3){
        params.put("firstName",first_name);
        params.put("lastName",last_name);
        params.put("email",email);
        params.put("programme",programme);
        params.put("courses", Arrays.asList(course1, course2, course3));
        APIActions.put(params, "/student/"+id);
    }

    @Step("Business Flow: Delete Existing Student from StudentsList")
    public static void deleteStudent(String id){
       APIActions.delete(id);
    }

    @Step("Business Flow: Count All Students in StudentsList")
    public static String totalCount() {
        String list = getStudentsProperty("firstName");
        String[] arr = list.split(",");
        int totalCount = arr.length;
        return Integer.toString(totalCount);
    }
}
