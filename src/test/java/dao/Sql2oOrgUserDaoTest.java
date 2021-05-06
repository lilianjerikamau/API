package dao;

import models.OrgUser;
//import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class Sql2oOrgUserDaoTest {
    private static Sql2oOrgUserDao userDao;
    private static Connection conn;

    @BeforeAll
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/database.sql'";
        Sql2o sql2o = new Sql2o(connectionString,""," ");

        userDao = new Sql2oOrgUserDao (sql2o);
        conn = sql2o.open();
    }
    @AfterEach
    public void tearDown() throws Exception {
        userDao.clearAllUsers();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    OrgUser testUser = new OrgUser("Lenny","Intern","Deployment",1);

    @Test
    public void checkWhetherAUserIsAddedInTheDB(){
        userDao.addUser(testUser);
        assertEquals(1,userDao.getAllUsers().size());
    }

    @Test
    public void checkSetsIdWhenAUserIsAdded(){
        int theTestUserId = testUser.getUserId();
        userDao.addUser(testUser);
        assertNotEquals(theTestUserId, testUser.getUserId());
    }

    @Test
    public void retrievesAllUsersThatAreAdded(){
        OrgUser testUser1 = new OrgUser("Lenny","Intern","Deployment",1);
        userDao.addUser(testUser);
        userDao.addUser(testUser1);
        assertEquals(2,userDao.getAllUsers().size());
    }

//    @Test
//    public void retrievesAUserInAnOrgByAnId(){
//        userDao.addUser(testUser);
//        OrgUser retrievedUser = userDao.findUserById(testUser.getUserId());
//        assertEquals(testUser,retrievedUser);
//    }

    @Test
    public void updateCorrectlyAllUserFields() throws Exception {
        userDao.addUser(testUser);
        userDao.updateUser(testUser.getUserId(), "Dennis", "Finance", "Manager", 2);
        OrgUser retrievedUser = userDao.findUserById(testUser.getUserId());
        assertNotEquals(testUser.getUserName(), retrievedUser.getUserName());
        assertNotEquals(testUser.getUserPosition(), retrievedUser.getUserPosition());
        assertNotEquals(testUser.getUserRole(), retrievedUser.getUserRole());
        assertNotEquals(testUser.getUserDepartmentId(), retrievedUser.getUserDepartmentId());
    }

    @Test
    public void deletesAUserByTheId(){
        OrgUser testUser1 = new OrgUser("Lenny","Intern","Deployment",1);
        userDao.addUser(testUser);
        userDao.addUser(testUser1);
        userDao.deleteUserById(testUser1.getUserId());
        assertEquals(1, userDao.getAllUsers().size());
    }

    @Test
    public void deletesAllUserFromTheDB(){
        OrgUser testUser1 = new OrgUser("Lenny","Intern","Deployment",1);
        userDao.addUser(testUser);
        userDao.addUser(testUser1);
        userDao.clearAllUsers();
        assertEquals(0, userDao.getAllUsers().size());
    }

}