package pack;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Person {


    public static enum Gender {
        NOT_SPECIFIED,
        MALE,
        FEMALE
    }

    private String surname;

    private String name;

    private LocalDate birthDate;

    private Gender gender;

    private boolean activated;

    public Person() {

    }

    public Person(String surname, String name, LocalDate birthDate, Gender gender, boolean activated) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.activated = activated;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", activated=" + activated +
                '}';
    }
}
