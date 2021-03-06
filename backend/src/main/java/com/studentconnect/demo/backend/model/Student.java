package com.studentconnect.demo.backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "students")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String about;
    private Set<Club> clubs;
    private Set<Activity> activities;
    private boolean isTeacher;
    private String title;
    private Set<Subject> subjects;

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @Column(name = "isteacher")
    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!userName.equals(student.userName)) return false;
        return password.equals(student.password);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                ", clubs=" + clubs +
                ", activities=" + activities +
                ", isTeacher=" + isTeacher +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
