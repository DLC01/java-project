package model;

public class Student {
    private int roll;
    private String name;
    private int age;
    private String course;

    public Student(int roll, String name, int age, String course) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getRoll() { return roll; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void setRoll(int roll) { this.roll = roll; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
}
