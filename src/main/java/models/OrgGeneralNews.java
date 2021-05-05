package models;

import java.util.Objects;

public class OrgGeneralNews {
    private int id;
    private String news_info;
    private String news_type;
    private int user_id;
    public OrgGeneralNews (int user_id,String news_info,String news_type){
        this.news_info = news_info;
        this.user_id = user_id;
        this.news_type = news_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews_info() {
        return news_info;
    }

    public void setNews_info(String news_info) {
        this.news_info = news_info;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgGeneralNews)) return false;
        OrgGeneralNews that = (OrgGeneralNews) o;
        return getId() == that.getId() && getUser_id() == that.getUser_id() && Objects.equals(getNews_info(), that.getNews_info()) && Objects.equals(getNews_type(), that.getNews_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNews_info(), getNews_type(), getUser_id());
    }
}
