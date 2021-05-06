package dao;

import models.OrgUser;

import java.util.List;

public interface OrgUserDao {
    //create
    //create
    void addUser (OrgUser user);

    //read
    List<OrgUser> getAllUsers();
    OrgUser findUserById(int userId);

    //update
    void updateUser(int userId, String userName, String userPosition, String userRole, int userDepartmentId);

    //delete
    void deleteUserById(int userId);
    void clearAllUsers();
}
