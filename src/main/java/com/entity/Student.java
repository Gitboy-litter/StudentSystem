package com.entity;

/**
 * @ProjectName: StudentSystem
 * @Package: com.entity
 * @ClassName: Student
 * @Author: QT
 * @Description: ${description}
 * @Date: 2020/9/15 17:53
 * @Version: 1.0
 */
public class Student {
  private   String sno;
  private   String sname;
  private   String ssex;
  private   Integer sage;
  private   String sdept;

    public Student() {
    }

    public Student(String sno, String sname, String ssex, Integer sage, String sdept) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sdept = sdept;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }
}
