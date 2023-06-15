import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Manager {
    int indexEmployee(ArrayList<Employee> arrayList, String id);
    void addEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException;
    boolean noEmployee(ArrayList<Employee> employees, String id);
    void searchAll(ArrayList<Employee> employees);
    void searchUni(ArrayList<Employee> employees, Scanner scanner);
    void updateInfo(ArrayList<Employee> employees, Scanner scanner) throws IOException;
    void removeEmployee(ArrayList<Employee> employees, Scanner scanner) throws IOException;
    void dump(ArrayList<Employee> employees) throws IOException;
    void load(ArrayList<Employee> employees) throws IOException;
    void showMain();
}
