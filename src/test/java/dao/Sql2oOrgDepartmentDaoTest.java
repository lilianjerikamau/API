package dao;
import org.junit.jupiter.api.Test;


import models.OrgDepartment;
import models.OrgDepartment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oOrgDepartmentDaoTest {

    private static  Sql2oOrgDepartmentDao departmentDao;
    private static Connection conn;

    @BeforeAll
    public static void setUp() throws Exception {
        String connectionString =  "jdbc:postgresql://localhost:5432/jadle_test";
        Sql2o sql2o = new Sql2o(connectionString,"sherry","password");

        departmentDao = new Sql2oOrgDepartmentDao (sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        departmentDao.clearAllDepartments();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    OrgDepartment testDepartment = setUpNewDepartment();

    @Test
    public void addingDepartmentSetsId() throws Exception {
        int originalDepartmentId = testDepartment.getDepartmentId();
        departmentDao.addDepartment(testDepartment);
        assertNotEquals(originalDepartmentId,testDepartment.getDepartmentId());
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAllDepartments() throws Exception {
        departmentDao.addDepartment(testDepartment);
        assertEquals(1, departmentDao.getAllDepartments().size());
    }

    @Test
    public void returnsEmptyListIfNoDepartmentExists() throws Exception {
        assertEquals(0, departmentDao.getAllDepartments().size());
    }

    @Test
    public void deletesADepartmentOnDeletionById() throws Exception {
        departmentDao.addDepartment(testDepartment);
        departmentDao.deleteDepartmentById(testDepartment.getDepartmentId());
        assertEquals(0, departmentDao.getAllDepartments().size());
    }

    @Test
    public void clearAll() throws Exception {
        OrgDepartment otherDepartment = setUpNewDepartment();
        departmentDao.clearAllDepartments();
        assertEquals(0, departmentDao.getAllDepartments().size());
    }


    // helpers

    public OrgDepartment setUpNewDepartment(){
        return new OrgDepartment("IT","Software");
    }


}