package com.luv2code.cruddemo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;


@Entity

@Table(name="student")
public class Student {
    //fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="first_name")
    @NotBlank(message = "First name cannot be empty")
    @Size(max = 50, message = "First name must be at most 50 characters")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message = "Last name cannot be empty")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    private String lastName;

    @Column(name="email")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;




    //constructors
    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //getter/setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString()


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
