package com.example.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.example.test.model.departement;
import com.example.test.model.employee;
import com.example.test.repository.DeptRepository;
import com.example.test.repository.UserRepository;
import com.example.test.util.Responsewrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")

public class maincontroller {

    private static final org.springframework.http.HttpStatus HttpStatus = null;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

   

    @GetMapping("/employee")
    public ResponseEntity<Responsewrapper<List<employee>>> getallemployee() {
        Responsewrapper<List<employee>> response = new Responsewrapper<List<employee>>();
        response.setResult(userRepository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Responsewrapper<Optional<employee>>> getemployeebyid(@PathVariable(value = "id") Long employeeId)
            throws EntityNotFoundException {
        userRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found on :: " + employeeId));
                Responsewrapper<Optional<employee>> response = new Responsewrapper<Optional<employee>>();
                response.setResult(userRepository.findById(employeeId));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/employee")
    public ResponseEntity<Responsewrapper<employee>> createEmployee(@Valid @RequestBody employee employe) {
        Responsewrapper<employee> response = new Responsewrapper<employee>();
        response.setResult(userRepository.save(employe));

        return new ResponseEntity<>(response, HttpStatus.CREATED);

        
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<employee> updateuser(@PathVariable(value = "id") Long employeeId,
            @Valid @RequestBody employee employeedetail) throws EntityNotFoundException {
        employee employe = userRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("User not found on ::" + employeeId));

        employe.setFirstname(employeedetail.getFirstname());
        employe.setLastname(employeedetail.getLastname());
        final employee updatedemployee = userRepository.save(employe);
        return ResponseEntity.ok(updatedemployee);
    }

    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteemployee(@PathVariable(value = "id") Long employeeId) throws Exception {
        employee employe = userRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("User not Found on::" + employeeId));
        userRepository.delete(employe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/employee/crossjoin")
    public ResponseEntity<ArrayList<departement>> crossjointesting() {
        System.out.print("cross join :");
        return ResponseEntity.ok(deptRepository.fetchCrossJoin());

    }

    @GetMapping("/employee/rightjoin")
    public ResponseEntity<List<departement>> rightjointesting() {
        System.out.print("Right join :");

        return ResponseEntity.ok(deptRepository.fetchRightJoin());

    }

    @GetMapping("/employee/leftjoin")
    public ResponseEntity<List<departement>> Leftjointesting() {
        System.out.print("Left join :");

        return ResponseEntity.ok(deptRepository.fetchLeftJoin());

    }

    @GetMapping("/employee/innerjoin")
    public ResponseEntity<List<departement>> innerjointesting() {
        System.out.print("Inner join :");

        return ResponseEntity.ok(deptRepository.fetchInnerJoin());
        
    }

    @GetMapping("/employee/sum")
    public int sumtesting() {
        System.out.print("sum(salary):");
        return userRepository.sum();
        
    }
    @GetMapping("/employee/min")
    public int mintesting() {
        System.out.print("min(salary) :");
        return userRepository.min();
        
    }
    @GetMapping("/employee/max")
    public int maxtesting() {
        System.out.print("max(salary) :");
        return userRepository.max();
        
    }
    @GetMapping("/employee/avg")
    public int avgtesting() {
        System.out.print("avg(salary) :");
        return userRepository.avg();
        
    }
    @GetMapping("/employee/count")
    public int couttesting() {
        System.out.print("count(salary) :");
        int dept = userRepository.cout();
        return dept;       
    }

}