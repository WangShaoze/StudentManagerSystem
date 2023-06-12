public class Student {
    /*
    * 学生类
    * */
    private String name;
    private String id;
    private String gender;
    private String age;

    private String address;

    public Student() {
    }

    public Student(String name, String id, String gender, String age, String address) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
