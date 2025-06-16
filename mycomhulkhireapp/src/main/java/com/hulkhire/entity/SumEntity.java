package com.hulkhire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sum_data") // Your DB table name
public class SumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int num1;
    private int num2;
    private int result;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }

    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }

    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }
}
