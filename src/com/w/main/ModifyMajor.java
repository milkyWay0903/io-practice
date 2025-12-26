package com.w.main;

import java.io.*;
import java.util.List;

public class ModifyMajor {
    public static void main(String[] args) {
        String scourePath = "mydate/student2024.txt";
        String targetPath = "mydate/student2024-1.txt";

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(scourePath));
            List<Student> students = (List<Student>) ois.readObject();

            int modifyCnt = 0;
            for (Student student : students) {
                if ("MATH".equals(student.getMajor())) {
                    student.setMajor("APMA");
                    modifyCnt++;
                }
            }
            System.out.println("已修改" + modifyCnt + "个学生的专业信息");

            oos = new ObjectOutputStream(new FileOutputStream(targetPath));
            oos.writeObject(students);
            System.out.println("修改后的数据已保存到文件：" + targetPath);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
