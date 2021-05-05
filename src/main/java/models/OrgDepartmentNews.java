package models;

import java.util.Objects;

public class OrgDepartmentNews extends OrgGeneralNews{
    private int id;
    public OrgDepartmentNews(int user_id, String news_info, String news_type) {
        super(user_id, news_info, news_type);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgDepartmentNews)) return false;
        if (!super.equals(o)) return false;
        OrgDepartmentNews that = (OrgDepartmentNews) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
