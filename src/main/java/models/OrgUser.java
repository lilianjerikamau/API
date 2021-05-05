package models;

import java.util.Objects;

public class OrgUser {
    private int id;
    private String user_name;
    private String user_position;
    private String user_role;
    private int department_id;
    public OrgUser(String user_name,String user_position,String user_role,int department_id){
        this.department_id = department_id;
        this.user_position = user_position;
        this.user_name = user_name;
        this.user_role = user_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_position() {
        return user_position;
    }

    public void setUser_position(String user_position) {
        this.user_position = user_position;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgUser)) return false;
        OrgUser orgUser = (OrgUser) o;
        return getId() == orgUser.getId() && getDepartment_id() == orgUser.getDepartment_id() && Objects.equals(getUser_name(), orgUser.getUser_name()) && Objects.equals(getUser_position(), orgUser.getUser_position()) && Objects.equals(getUser_role(), orgUser.getUser_role());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser_name(), getUser_position(), getUser_role(), getDepartment_id());
    }
}
