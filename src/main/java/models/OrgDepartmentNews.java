package models;

import java.util.Objects;

public class OrgDepartmentNews extends OrgGeneralNews {
    private int departmentNewsId;

    public OrgDepartmentNews( String newsInformation, String newsType, int newsUserId, int departmentNewsId) {
        super( newsInformation, newsType, newsUserId);
        this.departmentNewsId = departmentNewsId;
    }

    public int getDepartmentNewsId() {
        return departmentNewsId;
    }

    public void setDepartmentNewsId(int departmentNewsId) {
        this.departmentNewsId = departmentNewsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrgDepartmentNews that = (OrgDepartmentNews) o;
        return departmentNewsId == that.departmentNewsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departmentNewsId);
    }
}