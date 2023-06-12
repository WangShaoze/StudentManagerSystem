import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 创建学生对象的集合
        ArrayList<Student> students = new ArrayList<>();
        loadFromLocal(students);  // 加载学生数据

        // 创建主界面
        // 添加学生
        // 修改学生信息
        // 查看学生信息
        // 查看所有学生信息
        // 删除学生信息
        // 退出系统
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMainPage();
            // 创建用户输入功能菜单对象
            System.out.println("请输入对应的功能选项:");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    addStudent(students);
                    break;
                case "2":
                    updateStudentInfo(students, scanner);

                    break;
                case "3":
                    // 查看学生信息
                    searchStudent(students, scanner);
                    break;
                case "4":
                    showAll(students);
                    break;
                case "5":
                    removeStudent(students, scanner);
                    break;
                case "6":
                    // 退出系统
                    System.out.println("你已经退出系统，感谢使用！！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你的输入不合法！！请重试！");
                    break;
            }
        }
    }

    private static void updateStudentInfo(ArrayList<Student> students, Scanner scanner) throws IOException {
        // 修改学生信息
        String id;
        System.out.println("请输入你的学号:");
        id = scanner.nextLine();

        int index1=-1;
        for (int i = 0; i< students.size(); i++){
            Student student = students.get(i);
            if (id.equalsIgnoreCase(student.getId())){
                index1 = i;
                break;
            }
        }

        if (index1!=-1){
            Student student = students.get(index1);
            System.out.println("请输入你的姓名：");
            String name = scanner.nextLine();
            System.out.println("请输入你的年龄：");
            String age = scanner.nextLine();
            System.out.println("请输入你的性别: ");
            String gender = scanner.nextLine();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setGender(gender);
            dumpToLocal(students);
            System.out.println("信息设置成功！");
        }else {
            System.out.println("没有找到该学生的信息！");
        }
    }

    private static void removeStudent(ArrayList<Student> students, Scanner scanner) throws IOException {
        // 删除学生信息
        System.out.println("请输入学生的学号:");
        boolean flag = true;
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (id.equalsIgnoreCase(student.getId())) {
                // 找到学生的信息
                students.remove(i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("没有找到该学生的信息！！");
        }else {
            dumpToLocal(students);
            System.out.println("该学生已经被删除了！！");
        }
    }

    private static void showAll(ArrayList<Student> students) {
        // 查看所有学生信息
        System.out.println("学号"+"\t\t"+"姓名"+"\t\t\t"+"年龄"+"\t\t"+"性别");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getId()+"\t\t"+student.getName()+"\t\t"+student.getAge()+"\t\t"+student.getGender());
        }
    }

    private static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("请输入学生学号：");
        boolean flag = true;
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (id.equalsIgnoreCase(student.getId())) {
                System.out.println("学号"+"\t\t"+"姓名"+"\t\t\t"+"年龄"+"\t\t"+"性别");
                System.out.println(student.getId()+"\t\t"+student.getName()+"\t\t"+student.getAge()+"\t\t"+student.getGender());
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("没有找到该学生的信息！！");
        }
    }

    private static void addStudent(ArrayList<Student> students) throws IOException {
        // 添加学生
        // 判断学生的学号是否在集合中的某一对象上
        Scanner scanner = new Scanner(System.in);
        boolean out = false;

        String id;
        while (true){
            System.out.println("请输入你的学号:");
            id = scanner.nextLine();
            if (id.equalsIgnoreCase("q")){
                out = true;
                break;
            }
            boolean flag = true;
            for (int i=0; i<students.size();i++){
                if (id.equalsIgnoreCase(students.get(i).getId())){
                    flag = false;
                    break;
                }
            }
            if (flag){
                break;
            }else {
                System.out.println("已经有该学号！！请重试！若想退出添加学生，输入Q");
            }
        }

        if (out){
            return;
        }
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        String age = scanner.nextLine();
        System.out.println("请输入你的性别: ");
        String gender = scanner.nextLine();

        Student stu = new Student(id, name, age, gender);

        if (students.add(stu)){
            dumpToLocal(students);
            System.out.println("学生"+stu.toString()+" , 信息添加成功！！");
        }
    }

    private static void loadFromLocal(ArrayList<Student> students) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
        String line;
        while ((line=br.readLine())!=null){
            String[] strings = line.split(",");
            Student s = new Student(strings[0], strings[1],strings[2],strings[3]);
            students.add(s);
        }
        br.close();
    }

    private static void dumpToLocal(ArrayList<Student> students) throws IOException{
        // 创建输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("Students.txt"));
        for (int i=0; i<students.size();i++){
            Student st = students.get(i);
            bw.write(st.toFile());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
    private static void showMainPage() {
        System.out.println("--------------------------------------学生管理系统主界面--------------------------------------");
        System.out.println("1.添加学生");
        System.out.println("2.修改学生信息");
        System.out.println("3.查看学生信息");
        System.out.println("4.查看所有学生信息");
        System.out.println("5.删除学生信息");
        System.out.println("6.退出系统");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}