
/*
 * 学生管理系统主界面
 * 查看所有学生
 * 查询学生信息
 * 添加学生
 * 删除学生
 * 修改学生
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("学生管理系统测试端口");
        System.out.println("Hello world!");

        ArrayList<Student> arrayList = new ArrayList<>();

        while (true) {
            // 学生管理系统的主界面
            System.out.println("------------------------------学生管理系统----------------------------------------------");
            System.out.println("1.查看所有学生");
            System.out.println("2.查询学生信息");
            System.out.println("3.添加学生");
            System.out.println("4.删除学生");
            System.out.println("5.修改学生");
            System.out.println("6.退出");

            // 创建键盘录入对象
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    // 查看所有学生
                    findAllStudent(arrayList);
                    break;
                case "2":
                    // 查询学生信息
                    searchStudent(arrayList);
                    break;
                case "3":
                    // 添加学生
                    addStudent(arrayList);
                    break;
                case "4":
                    // 删除学生
                    removeStudent(arrayList);
                    break;
                case "5":
                    // 修改学生
                    updateStudentInfo(arrayList);
                    break;
                case "6":
                    // 退出
                    System.out.println("您已经退出，谢谢使用!");
                    System.exit(0);  // JVM退出。
                    break;
                default:
                    System.out.println("你输入的数字选项不存在，请重新输入");
            }
        }

    }

    public static void findAllStudent(ArrayList<Student> arrayList) {
        if (arrayList.size() == 0) {
            System.out.println("不好意思，没有可以查询的学生。");
            return;
        }
        System.out.println("学号" + "\t\t" + "姓名" + "\t\t" + "年龄" + "\t\t" + "性别" + "\t\t" + "居住地");
        for (int i = 0; i < arrayList.size(); i++) {
            Student s = arrayList.get(i);
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getGender() + "\t\t" + s.getAddress());
        }
    }

    public static void addStudent(ArrayList<Student> arrayList) {
        // 创建键盘录入
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生学号：");
            id = scanner.nextLine();

            // 判断学号是否被占用
            boolean flag = false;
            // 遍历集合
            for (int i = 0; i < arrayList.size(); i++) {
                Student stu = arrayList.get(i);
                // 获取学号，字母忽略大小写
                if (stu.getId().equalsIgnoreCase(id)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("该学号已经被占用！！请重新输入学号。");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄：");
        String age = scanner.nextLine();
        System.out.println("请输入学生性别：");
        String gender = scanner.nextLine();
        System.out.println("请输入学生地址：");
        String address = scanner.nextLine();
        Student student = new Student(name, id, gender, age, address);
        arrayList.add(student);

        // 提示
        System.out.println("添加学生成功！");
    }

    public static void removeStudent(ArrayList<Student> arrayList) {
        // 判断集合是否是空集合
        if (arrayList.size()==0){
            System.out.println("不好意思，没有可以查询的学生。");
            return;
        }

        // 删除学生
        // 键盘录入学号
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生学号:");
        String id = scanner.nextLine();

        // 定义索引
        int index = -1;
        // 遍历集合
        for (int i = 0; i < arrayList.size(); i++) {
            // 有删除
            Student student = arrayList.get(i);
            if (student.getId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没有找到该学号对应的学生，请回去重新你的选择！！");
        } else {
            arrayList.remove(index);
            System.out.println("已经将该学生删除。");
        }
    }

    public static void updateStudentInfo(ArrayList<Student> arrayList) {
        // 判断集合是否是空集合
        if (arrayList.size()==0){
            System.out.println("不好意思，没有可以查询的学生。");
            return;
        }

        // 修改学生信息
        // 键盘录入学号
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号:");
        String id = scanner.nextLine();
        // 定义索引
        int index = -1;
        // 遍历集合
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            if (student.getId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没有找到该学生；请重新进入");
        } else {
            Student student = arrayList.get(index);
            student.setId(id);

            System.out.println("请输入学生姓名：");
            String name = scanner.nextLine();
            student.setName(name);

            System.out.println("请输入学生年龄：");
            String age = scanner.nextLine();
            student.setAge(age);

            System.out.println("请输入学生性别：");
            String gender = scanner.nextLine();
            student.setGender(gender);

            System.out.println("请输入学生地址：");
            String address = scanner.nextLine();
            student.setAddress(address);

            System.out.println("学生的信息设置成功。");
        }
    }

    public static void searchStudent(ArrayList<Student> arrayList){
        // 判断集合是否是空集合
        if (arrayList.size()==0){
            System.out.println("不好意思，没有可以查询的学生。");
            return;
        }

        // 查询学员的信息

        // 输入学生的学号
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生的学号:");
        String id = scanner.nextLine();

        // 定义指针
        int index = -1;
        // 循环遍历学生数组
        for (int i=0; i<arrayList.size(); i++){
            Student student = arrayList.get(i);
            if (student.getId().equalsIgnoreCase(id)){
                index = i;
                break;
            }
        }

        // 判断是否存在该学员
        if (index == -1){
            System.out.println("没有该学生的信息；请重试。");
        }else {
            Student s = arrayList.get(index);
            System.out.println("学号" + "\t\t" + "姓名" + "\t\t" + "年龄" + "\t\t" + "性别" + "\t\t" + "居住地");
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getGender() + "\t\t" + s.getAddress());
        }
    }
}