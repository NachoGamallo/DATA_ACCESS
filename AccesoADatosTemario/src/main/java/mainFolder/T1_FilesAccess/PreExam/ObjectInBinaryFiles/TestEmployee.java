package mainFolder.T1_FilesAccess.PreExam.ObjectInBinaryFiles;

import java.io.Serializable;

public class TestEmployee implements Serializable {

    private String name;
    private boolean isBoss;
    private int age;

    public TestEmployee(String name, boolean isBoss, int age) {
        this.name = name;
        this.isBoss = isBoss;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestEmployee{" +
                "name='" + name + '\'' +
                ", isBoss=" + isBoss +
                ", age=" + age +
                '}';
    }
}
