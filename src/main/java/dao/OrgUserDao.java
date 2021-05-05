package dao;

import models.OrgUser;

import java.util.List;

public interface OrgUserDao {
    //create
    void addUser (OrgUser user);

    //read
    List<OrgUser> getAllUsers();
    OrgUser findUserById(int id);

    //update
    void updateUser(int id, String user_name, String user_position, String user_role, int department_id);

    //delete
    void deleteUserById(int id);
    void clearAllUsers();
}
