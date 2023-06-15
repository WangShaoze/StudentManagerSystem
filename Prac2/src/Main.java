import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        Manage manage = new Manage();
        manage.load(employees);
        while (true){
            manage.showMain();
            System.out.println("请输入功能序号: ");
            String num = scanner.nextLine();
            switch (num){
                case "1":
                    // 添加员工
                    manage.addEmployee(employees, scanner);
                    break;
                case "2":
                    // 查询所有员工
                    manage.searchAll(employees);
                    break;
                case "3":
                    // 查询个人员工信息
                    manage.searchUni(employees, scanner);
                    break;
                case "4":
                    // 修改员工信息
                    manage.updateInfo(employees, scanner);
                    break;
                case "5":
                    // 删除员工
                    manage.removeEmployee(employees, scanner);
                    break;
                case "6":
                    System.out.println("你已经退出系统！！欢迎你的再次使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("你的输入不合法！！！");
                    break;
            }
        }
    }
}