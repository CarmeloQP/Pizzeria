/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majo.pizzeria.model;

/**
 *
 * @author Laptop DELL 3405
 */
public class Cocinador extends Thread {

    private final Preparacion producto;

    public Cocinador(Preparacion producto) {
        this.producto = producto;
    }

    @Override
    public void run() {
        System.out.println("Iniciando preparación...");
        
        try {
            Thread.sleep(3000); // 3 segundos simulando cocción
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producto.preparar();
        System.out.println("Producto listo!");
    }
}