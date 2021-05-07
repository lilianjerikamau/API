import com.google.gson.Gson;
import dao.Sql2oOrgUserDao;
import dao.Sql2oOrgNewsDao;
import dao.Sql2oOrgDepartmentDao;
import models.OrgDepartment;
import models.OrgDepartmentNews;
import models.OrgGeneralNews;
import models.OrgUser;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Connection;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oOrgDepartmentDao departmentDao;
        Sql2oOrgNewsDao newsDao;
        Sql2oOrgNewsDao departmentNewsDao;
        Sql2oOrgUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString =  "jdbc:postgresql://localhost:5432/jadle"; //connect to jadle, not jadle_test!
        Sql2o sql2o = new Sql2o(connectionString,"sherry","password");

        departmentDao = new  Sql2oOrgDepartmentDao (sql2o);
        userDao = new Sql2oOrgUserDao(sql2o);
        newsDao = new Sql2oOrgNewsDao(sql2o);
        departmentNewsDao = new Sql2oOrgNewsDao(sql2o);
        conn = sql2o.open();

        post("/departments/new", "application/json", (req, res) -> {
            OrgDepartment department = gson.fromJson(req.body(), OrgDepartment.class);
            departmentDao.addDepartment(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAllDepartments());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findDepartmentById(departmentId));
        });

        post("/users/new", "application/json", (req, res) -> {
            OrgUser user = gson.fromJson(req.body(), OrgUser.class);
            userDao.addUser(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(userDao.getAllUsers());
        });

        get("/users/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int userId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(userDao.findUserById(userId));
        });

        post("/news/new", "application/json", (req, res) -> {
            OrgGeneralNews news = gson.fromJson(req.body(), OrgGeneralNews.class);
            newsDao.addOrgGeneralNews(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(newsDao.getAllGeneralNews());
        });

        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int newsId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.findGeneralNewsById(newsId));
        });

        post("/departmentNews/new", "application/json", (req, res) -> {
            OrgDepartmentNews departmentNews = gson.fromJson(req.body(), OrgDepartmentNews.class);
            departmentNewsDao.addOrgDepartmentsNews(departmentNews);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departmentNews);
        });

        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentNewsDao.getAllDepartmentNews());
        });

        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int newsId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentNewsDao.findDepartmentNewsById(newsId));
        });
    }
}

