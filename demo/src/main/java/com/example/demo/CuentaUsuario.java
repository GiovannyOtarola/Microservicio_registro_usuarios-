package com.example.demo;
import java.util.List;
import java.util.Map;;

public class CuentaUsuario {
    private int id;
    private String usuario;
    private String contraseña;
    private List<RolUsuario> rolUsuario;
    private Map<String, List<String>> datosUsuario;

    public CuentaUsuario(int id, String usuario, String contraseña, List<RolUsuario> rolUsuario, Map<String, List<String>> datosUsuario){
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rolUsuario = rolUsuario;
        this.datosUsuario = datosUsuario;

    }

    //Getters

    public int getId(){
        return id;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContraseña(){
        return contraseña;
    }

    public List<RolUsuario> getRolUsuario(){
        return rolUsuario;
    }

    public Map<String, List<String>> getDatosUsuario(){
        return datosUsuario;
    }

}
