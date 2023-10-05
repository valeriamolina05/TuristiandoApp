package org.example.controladores;

import org.example.entidades.Usuario;
import org.example.modelos.ModeloUsuario;
import org.example.servicios.ServicioUsuario;

import java.util.List;

public class ControladorUsuario {

    private Usuario usuario = new Usuario();//valida los datos de un nuevo usuario
    private ServicioUsuario servicioUsuario = new ServicioUsuario();

    //Ingresar datos a la entidad Usuario
    public void registrarUsuario(String documento, String nombre, String correo, Integer ubicacion){
        usuario.setNombres(nombre);
        usuario.setDocumento(documento);
        usuario.setUbicacion(ubicacion);
        usuario.setCorreo(correo);
        this.servicioUsuario.guardarDatosBD(usuario);
    }

    public  void consultarUsuarios(){
        List<ModeloUsuario> usuarios = this.servicioUsuario.consultarDatosEnBD();
        for (ModeloUsuario usuario: usuarios){
            System.out.println("Nombre: "+usuario.getNombres());
            System.out.println("-----------------------------------");
        }
    }

    public void consultarUsuariosJson(){}
}
