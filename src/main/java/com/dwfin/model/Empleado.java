package com.dwfin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String puesto;

    @Column (nullable = false)
    private Double salario;

    public Empleado(){}

    public Empleado(String nombre, String puesto, Double salario){
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    //Getter y Setters
    public Long getId(){return id; }
    public void setId(Long id){this.id = id;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getPuesto(){return puesto;}
    public void setPuesto(String puesto){this.puesto = puesto;}

    public Double getSalario(){return salario;}
    public void setSalario(Double salario){this.salario = salario;}
}
