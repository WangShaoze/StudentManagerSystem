import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // 定义学生集合
        ArrayList<Student> students = new ArrayList<>();

        // 加载学生数据
        loadLocalToArrayList(students);

        Scanner scanner = new Scanner(System.in);

        while (true){
            showMain();
            String num = scanner.nextLine();
            switch (num){
                case "1":
                    addStudent(students, scanner);
                    break;
                case "2":
                    searchInfo(students, scanner);
                    break;
                case "3":
                    showAll(students);
                    break;
                case "4":
                    updateInfo(students, scanner);
                    break;
                case "5":
                    removeStudent(students, scanner);
                    break;
                case "6":
                    System.out.println("你已经退出，感谢使用！！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你的输入不合法！！请重试！！");
                    break;
            }
        }
    }

    private static void removeStudent(ArrayList<Student> students, Scanner scanner) throws IOException {
        // 删除学生
        String id;
        int index = -1;
        System.out.println("请输入学生学号:");
        id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (id.equalsIgnoreCase(students.get(i).getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            students.remove(index);
            dumpArrayListToLocal(students);
            System.out.println("学生已经删除。");
        } else {
            System.out.println("没有找到该学生的信息！！");
        }
    }

    private static void updateInfo(ArrayList<Student> students, Scanner scanner) throws IOException {
        // 修改学生信息
        String id;
        int index = -1;
        System.out.println("请输入学生学号:");
        id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (id.equalsIgnoreCase(students.get(i).getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("请输入学生名字: ");
            String name = scanner.nextLine();
            System.out.println("请输入学生年龄: ");
            String age = scanner.nextLine();
            Student stu = students.get(index);
            stu.setName(name);
            stu.setAge(age);
            dumpArrayListToLocal(students);
        } else {
            System.out.println("没有找到该学生的信息！！");
        }
    }

    private static void showAll(ArrayList<Student> students) {
        // 查询所有学生
        System.out.println("学号\t\t姓名\t\t\t年龄");
        for (int i = 0; i< students.size(); i++){
            Student student = students.get(i);
            StringBuffer sb = new StringBuffer();
            sb.append(student.getId()).append("\t\t");
            sb.append(student.getName()).append("\t\t\t");
            sb.append(student.getAge());
            System.out.println(sb.toString());
        }
    }

    private static void searchInfo(ArrayList<Student> students, Scanner scanner) {
        String id;

        int index = -1;
        System.out.println("请输入学生学号:");
        id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (id.equalsIgnoreCase(students.get(i).getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(students.get(index).toString());
        } else {
            System.out.println("没有找到该学生的信息！！");
        }
    }

    private static void addStudent(ArrayList<Student> students, Scanner scanner) throws IOException {
        String id;
        while (true){
            boolean flag = false;
            System.out.println("请输入你的学号:");
            id = scanner.nextLine();
            for (int i = 0; i< students.size(); i++){
                if (id.equalsIgnoreCase(students.get(i).getId())){
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("已经有学号为"+id+"的学生，换一个吧！");
            }else {
                break;
            }
        }
        System.out.println("请输入学生名字: ");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄: ");
        String age = scanner.nextLine();
        Student stu = new Student(id, name, age);
        students.add(stu);

        dumpArrayListToLocal(students);

    }

    private static void dumpArrayListToLocal(ArrayList<Student> students) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("StuInfo.txt"));
        for (int i = 0; i< students.size(); i++){
            Student student = students.get(i);
            StringBuffer sb = new StringBuffer();
            sb.append(student.getId()).append(",");
            sb.append(student.getName()).append(",");
            sb.append(student.getAge());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    private static void loadLocalToArrayList(ArrayList<Student> students) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("StuInfo.txt"));
        String line;
        while ((line=br.readLine())!=null){
            String[] info = line.split(",");
            Student student = new Student(info[0], info[1], info[2]);
            students.add(student);
        }
    }

    private static void showMain() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("———————————————————————————————————————————————— 主界面 ————————————————————————————————————————————————");
        System.out.println("1.添加学生");
        System.out.println("2.学生信息查询");
        System.out.println("3.查询所有学生");
        System.out.println("4.修改学生信息");
        System.out.println("5.删除学生");
        System.out.println("6.退出");
    }
}

class Student{
    private String id;
    private String name;

    private String age;

    public Student() {
    }

    public Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "学生{ 学号: "+this.id+", 姓名： "+this.name+", 年龄："+this.age+" }";
    }
}