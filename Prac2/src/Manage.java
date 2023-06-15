import javax.sound.midi.Soundbank;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Manage implements Manager{

    @Override
    public int indexEmployee(ArrayList<Employee> arrayList, String id) {
        int index=-1;
        for (int i=0; i<arrayList.size();i++){
            if (id.equalsIgnoreCase(arrayList.get(i).getId())){
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public void addEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        System.out.println("请输入你的学号:");
        String id = scanner.nextLine();
        if (!noEmployee(employees, id)){
            System.out.println("已有该员工！！！");
        }else {
            System.out.println("请输入你的姓名:");
            String name = scanner.nextLine();
            System.out.println("请输入你的年龄:");
            String age = scanner.nextLine();
            Employee employee = new Employee(id, name, Integer.parseInt(age));
            if (employees.add(employee)){
                dump(employees);
                System.out.println("员工添加成功。");
            }else {
                System.out.println("由于某种原因，信息添加失败！！");
            }
        }
    }

    @Override
    public boolean noEmployee(ArrayList<Employee> employees, String id) {
        boolean flag=true;
        if (indexEmployee(employees, id)!=-1){
            flag=false;
        }
        return flag;
    }

    @Override
    public void searchAll(ArrayList<Employee> employees) {
        System.out.println("工号\t\t\t姓名\t\t\t年龄");
        for (Employee e:
             employees) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void searchUni(ArrayList<Employee> employees, Scanner scanner) {
        System.out.println("请输入你的学号:");
        String id = scanner.nextLine();
        int index=indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该员工！！！");
        }else {
            System.out.println("工号\t\t\t姓名\t\t\t年龄");
            System.out.println(employees.get(index).toString());
        }
    }

    @Override
    public void updateInfo(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        System.out.println("请输入你的学号:");
        String id = scanner.nextLine();
        int index=indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该员工！！！");
        }else {
            System.out.println("请输入你的姓名:");
            String name = scanner.nextLine();
            System.out.println("请输入你的年龄:");
            String age = scanner.nextLine();
            Employee employee = employees.get(index);
            employee.setId(id);
            employee.setAge(Integer.parseInt(age));
            employee.setName(name);
            dump(employees);
            System.out.println("信息修改成功！");
        }
    }

    @Override
    public void removeEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException {
        System.out.println("请输入你的学号:");
        String id = scanner.nextLine();
        int index=indexEmployee(employees, id);
        if (index==-1){
            System.out.println("没有该员工！！！");
        }else {
            employees.remove(index);
            dump(employees);
            System.out.println("该员工已经删除！");
        }
    }

    @Override
    public void dump(ArrayList<Employee> employees) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Employees.txt"));
        for (Employee e:
             employees) {
            bw.write(e.toContent());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    @Override
    public void load(ArrayList<Employee> employees) throws IOException {
        File file = new File("Employees.txt");
        if (!file.exists()){
            file.createNewFile();
        } else if (file.length()==0) {
            return;
        }
        else {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine())!=null){
                String[] strings = line.split(",");
                Employee employee = new Employee(strings[0], strings[1], Integer.parseInt(strings[2]));
                employees.add(employee);
            }
            br.close();
        }
    }

    @Override
    public void showMain() {
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
