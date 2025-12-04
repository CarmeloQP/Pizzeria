/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majo.pizzeria.model;

/**
 *
 * @author Laptop DELL 3405
 */
public class  Bebida implements Preparacion {
    
    private String nombre;

    public Bebida(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void preparar() {
        System.out.println("Sirviendo la bebida: " + nombre);
    }
}
