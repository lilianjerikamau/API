package dao;
import models.OrgDepartment;
import models.OrgDepartmentNews;
import models.OrgGeneralNews;
import models.OrgUser;

import java.util.List;

public interface OrgDepartmentDao {
    //create
    void addDepartment(OrgDepartment department);

    //read
    List<OrgDepartment> getAllDepartments();
    OrgDepartment findDepartmentById(int departmentId);
//    List<OrgUser> getUsersForADepartment(int userDepartmentId);
//    List<OrgDepartmentNews> getNewsForADepartment(int departmentId);

    //update
    void updateDepartment(OrgDepartment department, String departmentName, String departmentDescription);

    //delete
    void deleteDepartmentById(int departmentId);
    void clearAllDepartments();
}
