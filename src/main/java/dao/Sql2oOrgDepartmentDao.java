package dao;

import groovy.sql.Sql;
import models.OrgDepartment;
import models.OrgDepartmentNews;
import models.OrgGeneralNews;
import models.OrgUser;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.stream.Collectors;


public class Sql2oOrgDepartmentDao implements OrgDepartmentDao{
    private final Sql2o sql2o;
    private final Sql2oOrgUserDao userDao;
    private final Sql2oOrgNewsDao newsDao;

    public Sql2oOrgDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
        this.userDao = new Sql2oOrgUserDao(sql2o);
        this.newsDao = new Sql2oOrgNewsDao(sql2o);

    }

    @Override
    public void addDepartment(OrgDepartment department){
        String sql = "INSERT INTO departments(name,description) values (:departmentName,:departmentDescription);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setDepartmentId(id);
        }
    }
    @Override
    public List<OrgDepartment> getAllDepartments() {
        String sql ="SELECT * FROM departments";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(OrgDepartment.class);
        }

    }

    @Override
    public  OrgDepartment findDepartmentById(int departmentId) {
        String sql ="SELECT * FROM departments where id = :id ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",departmentId)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(OrgDepartment.class);
        }
    }

//    @Override
//    public  List<organizationUser> getUsersForADepartment(int userDepartmentId){
//        String sql ="SELECT * FROM users where departmentId = :userDepartmentId ";
//        try(Connection con = sql2o.open()){
//            return con.createQuery(sql)
//                    .addParameter("userDepartmentId",departmentId)
////                    .throwOnMappingFailure(false)
//                    .executeAndFetchFirst(organizationUser.class);
//        }
//    }
//
//    @Override
//    public  List<OrgDepartmentNews> getNewsForADepartment(int departmentId){
//        String sql ="SELECT * FROM news where departmentId = :departmentNewsId ";
//        try(Connection con = sql2o.open()){
//            return con.createQuery(sql)
//                    .addParameter("userDepartmentId",departmentId)
////                    .throwOnMappingFailure(false)
//                    .executeAndFetchFirst(OrgDepartmentNews.class);
//        }
//    }

    @Override
    public void updateDepartment(OrgDepartment department, String departmentName, String departmentDescription) {
        String sql ="UPDATE departments set (department_name, department_description) = (:name, :description) ";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name",departmentName)
                    .addParameter("description",departmentDescription)
                    .executeUpdate();
            department.setDepartmentName(departmentName);
            department.setDepartmentDescription(departmentDescription);
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        String sql = "DELETE FROM departments WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllDepartments() {
        String sql =" DELETE FROM departments";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }
    }
}