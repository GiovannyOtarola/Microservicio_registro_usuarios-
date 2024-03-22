package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CuentaUsuarioController {
    private List<CuentaUsuario> cuentaUsuarios = new ArrayList<>();
   

    public CuentaUsuarioController(){
      
        cuentaUsuarios.add(new CuentaUsuario(1, "Pedrito@14", "123456",
                            Arrays.asList(new RolUsuario(1, "administrador")),llenarListaDatosUsuarios("administrador", "4506725-8", "Pedro Juan", "Alvarez Gutierrez", "28 años", "Casa Feliz #3248")));


        cuentaUsuarios.add(new CuentaUsuario(2, "Pedrito@13", "852174",
                            Arrays.asList(new RolUsuario(1, "administrador")),llenarListaDatosUsuarios("administrador", "5506725-8", "Alvaro Camilo", "Alvarez Gutierrez", "44 años", "Avenida Providencia 1234") ));

        cuentaUsuarios.add(new CuentaUsuario(3, "Pedrito@12", "9654789", 
                            Arrays.asList(new RolUsuario(2, "Invitado")),llenarListaDatosUsuarios("Invitado", "4706725-8", "Matias Juan", "Alvarez Gutierrez", "36 años", "Calle Los Almendros 567")));

        cuentaUsuarios.add(new CuentaUsuario(4, "Pedrito@11", "65412387", 
                            Arrays.asList(new RolUsuario(3, "Cliente")),llenarListaDatosUsuarios("Cliente", "9506725-k", "Juan Pedro", "Alvarez Gutierrez", "51 años", "Pasaje Los Pinos 890")));

        cuentaUsuarios.add(new CuentaUsuario(5, "Pedrito@10", "85296314", 
                            Arrays.asList(new RolUsuario(4, "Colaborador")),llenarListaDatosUsuarios("Colaborador", "7506725-0", "Jose Miguel", "Alvarez Gutierrez", "35 años", "Calle Los Robles 789")));
    }

    private Map<String, List<String>> llenarListaDatosUsuarios (String rol,String rut, String nombres, String apellidos, String edad, String direccion){

        Map<String, List<String>> retorno = new HashMap<String, List<String>>();
        List<String> datosUsuario = Arrays.asList(rut, nombres, apellidos, edad, direccion);

        retorno.put(rol, datosUsuario);
        return retorno;
    }

    @GetMapping("/cuentaUsuarios")
    public List<CuentaUsuario> getCuentaUsuarios() {
        return cuentaUsuarios;
    }

    @GetMapping("/cuentaUsuarios/{id}")
    public ResponseEntity<?> getCuentaUsuarioById(@PathVariable int id) {
    for (CuentaUsuario cuentaUsuario : cuentaUsuarios) {
        if (cuentaUsuario.getId() == id) {
            return ResponseEntity.ok(cuentaUsuario);
        }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ninguna cuenta de usuario con el ID proporcionado.");
    }

    
    
}
