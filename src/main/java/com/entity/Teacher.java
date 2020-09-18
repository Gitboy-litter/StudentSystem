package com.entity;

/**
 * @ProjectName: StudentSystem
 * @Package: com.entity
 * @ClassName: Teacher
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/17 16:39
 * @Version: 1.0
 */
public class Teacher {
    private String tno;
    private String tname;
    private String tsex;
    private String tage;
    private String teb;
    private String tpt;
    private String cno1;
    private String cno2;
    private String cno3;

    public Teacher() {
    }

    public Teacher(String tno, String tname, String tsex, String tage, String teb, String tpt, String cno1, String cno2, String cno3) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.tage = tage;
        this.teb = teb;
        this.tpt = tpt;
        this.cno1 = cno1;
        this.cno2 = cno2;
        this.cno3 = cno3;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTage() {
        return tage;
    }

    public void setTage(String tage) {
        this.tage = tage;
    }

    public String getTeb() {
        return teb;
    }

    public void setTeb(String teb) {
        this.teb = teb;
    }

    public String getTpt() {
        return tpt;
    }

    public void setTpt(String tpt) {
        this.tpt = tpt;
    }

    public String getCno1() {
        return cno1;
    }

    public void setCno1(String cno1) {
        this.cno1 = cno1;
    }

    public String getCno2() {
        return cno2;
    }

    public void setCno2(String cno2) {
        this.cno2 = cno2;
    }

    public String getCno3() {
        return cno3;
    }

    public void setCno3(String cno3) {
        this.cno3 = cno3;
    }
}
