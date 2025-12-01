package beans;

public class Student {
    private int rollno;
    private String name;
    private int age;
    private String gender;
    private String email;

    public Student() {}

    public Student(int rollno, String name, int age, String gender, String email) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public int getRollno() { return rollno; }
    public void setRollno(int rollno) { this.rollno = rollno; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
