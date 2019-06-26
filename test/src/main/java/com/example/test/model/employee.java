package com.example.test.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * employee
 */
@Entity
@Table(name = "employee")


public class employee implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;
    

    @Column(name = "salary", nullable = false)
        private Long salary;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "departement")
        private List<departement> employee;

    public Long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public Long getSalary(){
        return salary;
    }

    public void setSalary(long salary){
        this.salary=salary;
    }

    
}