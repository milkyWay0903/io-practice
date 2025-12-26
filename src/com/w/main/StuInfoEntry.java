package com.w.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StuInfoEntry {
    public static void main(String[] args) {
        String filePath = "mydate/student2024.txt";

        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream oos = null;

        try {
            System.out.println("请输入学生信息（输入quit表示输入完毕）");

            while (true) {
                System.out.print("请输入学号：");
                String stuId = scanner.nextLine().trim();

                if ("quit".equals(stuId) || "QUIT".equals(stuId)) {
                    System.out.println("输入完毕");
                    break;
                }

                System.out.print("请输入姓名：");
                String name = scanner.nextLine().trim();
                System.out.print("请输入出生日期：");
                String birthDate = scanner.nextLine().trim();
                System.out.print("请输入性别：");
                String gender = scanner.nextLine().trim();
                System.out.print("请输入专业：");
                String major = scanner.nextLine().trim();

                Student student = new Student(stuId, name, birthDate, gender, major);
                students.add(student);
                System.out.println("已添加学生：" + student);
            }

            if (!students.isEmpty()) {
                oos = new ObjectOutputStream(new FileOutputStream(filePath));
                oos.writeObject(students);
                System.out.println(students.size() + "名学生的数据已保存到文件：" + filePath);
            } else {
                System.out.println("没有学生数据");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }
}
