package com.example.demo;

public class RolUsuario {
    private int idrol;
    private String nombre;
   


    public RolUsuario(int idrol, String nombre){
        this.idrol = idrol;
        this.nombre = nombre;
        
    } 

    //Getters
    public int getIdrol(){
        return idrol;
    }

    public String getNombre(){
        return nombre;
    }

    

}
