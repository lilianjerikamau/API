package dao;

import models.OrgDepartmentNews;
import models.OrgGeneralNews;

import java.util.List;

public interface OrgNewsDao {
    //create
    void addOrganizationGeneralNews(OrgGeneralNews generalNews);
    void addOrganizationDepartmentsNews(OrgDepartmentNews departmentNews);

    //read
    List<OrgGeneralNews> getAllGeneralNews();
    List<OrgDepartmentNews> getAllDepartmentNews();
    OrgGeneralNews findGeneralNewsById(int generalNewsId);
    OrgDepartmentNews findDepartmentNewsById(int departmentNewsId);

    //update
    void updateGeneralNews(OrgGeneralNews general_news, String news_info, int user_id);
    void updateDepartmentNews(OrgDepartmentNews departmentNews, String newsData, int departmentId, int userId);

    //delete
    void deleteGeneralNewsById(int newsId);
    void deleteDepartmentNewsById(int newsId);
    void clearGeneralNews();
    void clearDepartmentNews();
    void clearAllNews();
}
