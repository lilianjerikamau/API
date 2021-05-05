package models;

import java.util.Objects;

public class OrgDepartment {
    private int id;
    private String department_name;
    private String department_description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_description() {
        return department_description;
    }

    public void setDepartment_description(String department_description) {
        this.department_description = department_description;
    }

    public OrgDepartment (String department_name, String department_description){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgDepartment)) return false;
        OrgDepartment that = (OrgDepartment) o;
        return getId() == that.getId() && Objects.equals(getDepartment_name(), that.getDepartment_name()) && Objects.equals(getDepartment_description(), that.getDepartment_description());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartment_name(), getDepartment_description());
    }
}
