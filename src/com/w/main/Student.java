package com.w.main;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String stuId;
    private String name;
    private String birthDate;
    private String gender;
    private String major;

    public Student(String stuId, String name, String birthDate, String gender, String major) {
        this.stuId = stuId;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.major = major;
    }

    public String getStuId() {
        return stuId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("学号：%s, 姓名：%s, 出生日期：%s, 性别：%s, 专业：%s",
                stuId, name, birthDate, gender, major);
    }
}
