/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.majo.pizzeria.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Laptop DELL 3405
 */
public class PizzaDAO {

    public boolean guardarPizza(Pizza pizza) {
        String sql = "INSERT INTO pizzas(nombre, ingredientes, precio) VALUES (?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pizza.getNombre());
            ps.setString(2, String.join(", ", pizza.getIngredientes()));
            ps.setInt(3, pizza.getPrecio());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
