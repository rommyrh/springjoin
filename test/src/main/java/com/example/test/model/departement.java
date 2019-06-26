package com.example.test.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * departement
 * 
 */
@Entity
@Table(name = "departement")

public class departement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(name = "dept_name", nullable = false)
    private String dept_name;

  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept")
    private employee departement;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getDept_name(){
        return dept_name;
    }

    public void setDept_name(String dept_name){
        this.dept_name = dept_name;
    }

    public employee getDepartement() {
        return departement;
    }

    public void setDepartement(employee departement) {
        this.departement = departement;
    }

   

   
}