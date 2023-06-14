import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        load(employees);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMain();
            System.out.println("请输入功能菜单:");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    // 添加员工
                    addEmployee(employees, scanner);
                    break;
                case "2":
                    // 查询所有员工
                    searchAll(employees, scanner);
                    break;
                case "3":
                    // 查询个人员工信息
                    searchUni(employees, scanner);
                    break;
                case "4":
                    // 修改员工信息
                    updateInfo(employees, scanner);
                    break;
                case "5":
                    // 删除员工
                    removeEmployee(employees, scanner);
                    break;
                case "6":
                    System.out.println("你已经退出系统！！感谢使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你的输入不合法！！重试！");
                    break;
            }

        }
    }

    public static void addEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        // 添加员工
        System.out.println("请输入员工编号：");
        String id = scanner.nextLine();
        if (noEmployee(employees, id)){
            System.out.println("已经有员工的工号是: " + id + " 请重试！");
        }else {
            System.out.println("请输入员工姓名：");
            String name = scanner.nextLine();
            System.out.println("请输入员工年龄：");
            String age = scanner.nextLine();
            Employee employee = new Employee(id, name, age);
            if (employees.add(employee)) {
                dump(employees);
                System.out.println("员工的工号是" + id + "员工信息添加成功！");
            } else {
                System.out.println("由于某种原因，添加失败，请重试！");
            }
        }
    }

    private static boolean noEmployee(ArrayList<Employee> employees, String id) {
        boolean flag = false;
        for (Employee employee : employees) {
            if (id.equalsIgnoreCase(employee.getId())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static int indexEmployee(ArrayList<Employee> employees, String id) {
        int index=-1;
        for (int i=0; i<employees.size();i++){
            if (id.equalsIgnoreCase(employees.get(i).getId())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void searchAll(ArrayList<Employee> employees, Scanner scanner) {
        // 查询所有员工
        System.out.println("编号\t\t姓名\t\t\t年龄");
        for (Employee e:
             employees) {
            System.out.println(e.show());
        }
    }

    public static void searchUni(ArrayList<Employee> employees, Scanner scanner) {
        // 查询个人员工信息
        System.out.println("请输入员工编号：");
        String id = scanner.nextLine();
        int index = indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该学员！");
        }else {
            System.out.println("编号\t\t姓名\t\t\t年龄");
            System.out.println(employees.get(index).show());
        }
    }

    public static void updateInfo(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        // 修改员工信息
        System.out.println("请输入员工编号：");
        String id = scanner.nextLine();
        int index = indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该学员！");
        }else {
            System.out.println("请输入员工姓名：");
            String name = scanner.nextLine();
            System.out.println("请输入员工年龄：");
            String age = scanner.nextLine();
            Employee employee = employees.get(index);
            employee.setName(name);
            employee.setAge(age);
            dump(employees);
            System.out.println("员工"+id+"的信息修改成功！！");
        }
    }

    public static void removeEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        // 删除员工
        System.out.println("请输入员工编号：");
        String id = scanner.nextLine();
        int index = indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该学员！");
        }else{
            employees.remove(index);
            System.out.println("学员id为"+id+"的学员已经删除");
            dump(employees);
        }
    }

    private static void dump(ArrayList<Employee> employees) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt"));
        for (Employee employee : employees) {
            bw.write(employee.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    private static void load(ArrayList<Employee> employees) throws IOException {
        File file = new File("employees.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else if (file.length() == 0) {
            return;
        } else {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                Employee employee = new Employee(strings[0], strings[1], strings[2]);
                employees.add(employee);
            }
            br.close();
        }
    }

    private static void showMain() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("——————————————————————————————————————————————————————————————主界面——————————————————————————————————————————————————————————————");
        System.out.println("1.添加员工");
        System.out.println("2.查询所有员工");
        System.out.println("3.查询个人员工信息");
        System.out.println("4.修改员工信息");
        System.out.println("5.删除员工");
        System.out.println("6.退出系统");
    }
}