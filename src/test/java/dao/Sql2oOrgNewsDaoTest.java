package dao;
import org.junit.jupiter.api.Test;
import models.OrgDepartmentNews;
import models.OrgGeneralNews;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

public class Sql2oOrgNewsDaoTest {
    private static Sql2oOrgNewsDao newsDao;
    private static Sql2oOrgNewsDao departmentNewsDao;
    private static Connection conn;

    @BeforeAll
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/database.sql'";
        Sql2o sql2o = new Sql2o(connectionString,""," ");

        newsDao = new Sql2oOrgNewsDao(sql2o);
        departmentNewsDao= new Sql2oOrgNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        newsDao.clearAllNews();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
    }

    OrgGeneralNews testNews = setUpGeneralNews();

    @Test
    public void setsIdOnAddingNews(){
        int originalUserId = testNews.getNewsId();
        newsDao.addOrgGeneralNews(testNews);
        assertNotEquals(originalUserId,testNews.getNewsId());
    }

    @Test
    public void addedGeneralNewsAreReturnedFromGetAllGeneralNews() throws Exception {
        newsDao.addOrgGeneralNews(testNews);
        assertEquals(0, newsDao.getAllGeneralNews().size());
    }

    @Test
    public void returnsEmptyListIfNoGeneralNewsExists() throws Exception {
        assertEquals(0, newsDao.getAllGeneralNews().size());
    }

    @Test
    public void deletesAGeneralNewsOnDeletionById() throws Exception {
        newsDao.addOrgGeneralNews(testNews);
        newsDao.deleteGeneralNewsById(testNews.getNewsId());
        assertEquals(0, newsDao.getAllGeneralNews().size());
    }

    @Test
    public void clearAll() throws Exception {
        OrgGeneralNews otherGeneralNews = setUpGeneralNews();
        newsDao.clearGeneralNews();
        assertEquals(0, newsDao.getAllGeneralNews().size());
    }



    // helpers

    public OrgGeneralNews setUpGeneralNews(){
        return new OrgGeneralNews("This is news","General",1);
    }

    public OrgDepartmentNews setUpDepartmentNews(){
        return new OrgDepartmentNews("This is news","General",1,1);
    }

}

