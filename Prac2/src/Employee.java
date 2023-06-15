public class Employee {
    private String id;
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        if (age<18){
            age = 18;
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<18){
            age = 18;
        }
        this.age = age;
    }

    public String toContent(){
        return this.id+","+this.name+","+this.age;
    }
    @Override
    public String toString(){
        return this.id+"\t\t\t"+this.name+"\t\t\t"+this.age;
    }
}
