package cn.itcast.domain;

public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phonenum;
    private Integer credentialstype;
    private String credentialsnum;
    private Integer travellertype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getCredentialstype() {
        return credentialstype;
    }

    public void setCredentialstype(Integer credentialstype) {
        this.credentialstype = credentialstype;
    }

    public String getCredentialsnum() {
        return credentialsnum;
    }

    public void setCredentialsnum(String credentialsnum) {
        this.credentialsnum = credentialsnum;
    }

    public Integer getTravellertype() {
        return travellertype;
    }

    public void setTravellertype(Integer travellertype) {
        this.travellertype = travellertype;
    }
}
