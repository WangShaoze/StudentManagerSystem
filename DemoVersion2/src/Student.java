public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;

    public Student(){}

    public Student(String id, String name, String age, String gender){
        this.id = id;
        this.name =  name;
        this.age = age;
        this.gender = gender;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String toFile(){
        StringBuffer bf = new StringBuffer();
        bf.append(this.id).append(",");
        bf.append(this.name).append(",");
        bf.append(this.age).append(",");
        bf.append(this.gender);
        return bf.toString();
    }
}
