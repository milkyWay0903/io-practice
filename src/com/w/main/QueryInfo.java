package com.w.main;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QueryInfo {
    public static void main(String[] args) {
        String filePath = "mydate/student2024.txt";
        Scanner scanner = new Scanner(System.in);
        ObjectInputStream ois = null;
        Map<String, Student> studentMap = new HashMap<>();

        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            List<Student> studentList = (List<Student>) ois.readObject();
            for (Student student : studentList) {
                studentMap.put(student.getStuId(), student);
            }

            while (true) {
                System.out.print("请输入要查询的学号：");
                String stuId = scanner.nextLine().trim();
                Student student = studentMap.get(stuId);
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("未找到学号为" + stuId + "对应的学生信息");
                }
            }

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
            scanner.close();
        }
    }
}
