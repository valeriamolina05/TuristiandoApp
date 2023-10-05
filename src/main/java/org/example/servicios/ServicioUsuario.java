package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.Usuario;
import org.example.modelos.ModeloUsuario;

import java.util.List;
import java.util.Locale;

public class ServicioUsuario {

    public void guardarDatosBD(Usuario usuario){ //Nombre de la entidad configurada en el ORM

        //Nombre de la persistencia
        String persistenciaNombre = "conexionbd";

        //Conexión con las entidades
        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try{
            //Establecemos conexion a BD
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
            manejadorConexionEntidades=conexionEntidades.createEntityManager();

            //Creacion de tabla y operacion en BD
            ModeloUsuario modeloUsuario = new ModeloUsuario();

            //Llevar a la BD los datos que me envia el controlador
            modeloUsuario.setNombres(usuario.getNombres());
            modeloUsuario.setDocumento(usuario.getDocumento());
            modeloUsuario.setCorreo(usuario.getCorreo());
            modeloUsuario.setUbicacion(usuario.getUbicacion());

            //Iniciamos el envio de datos
            manejadorConexionEntidades.getTransaction().begin();

            //Persisitir los datos
            manejadorConexionEntidades.persist(modeloUsuario);

            //Se confirma que la BD respondio (Confirmar transaccion)
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("Registro exitoso Usuario");

        }catch(Exception error){
            //Capturo porque fallo la operacion en BD
            error.getStackTrace();
            System.out.println(error.getMessage());
        }finally{
            if (manejadorConexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
            if (conexionEntidades!=null){
                conexionEntidades.close();
            }
        }
    }

    public List<ModeloUsuario> consultarDatosEnBD(){

        //Nombre de la persistencia
        String persistenciaNombre = "conexionbd";

        //Conexión con las entidades
        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try {
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
            manejadorConexionEntidades=conexionEntidades.createEntityManager();

            //pedir los datos usando consultas en la BD
            //JSQL
            String consulta = "SELECT modelousuario ModeloUsuario modelousuario";
            //Ejecutar la consulta
            List<ModeloUsuario> usuarios =  manejadorConexionEntidades.createQuery(consulta, ModeloUsuario.class).getResultList();
            return usuarios;

        }catch (Exception error){
            System.out.println(error.getMessage());
            return null;
        }finally {
            if (manejadorConexionEntidades!=null){
                manejadorConexionEntidades.close();
            }
            if (conexionEntidades!=null){
                conexionEntidades.close();
            }

        }
    }

}
