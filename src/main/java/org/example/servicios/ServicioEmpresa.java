package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.Empresa;
import org.example.modelos.ModeloEmpresa;

public class ServicioEmpresa {

    public void guardarDatosBD(Empresa empresa){

        String persistenciaNombre = "conexionbd";
        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try{
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);

            manejadorConexionEntidades=conexionEntidades.createEntityManager();

            ModeloEmpresa modeloEmpresa = new ModeloEmpresa();

            modeloEmpresa.setNit(empresa.getNit());
            modeloEmpresa.setNombre(empresa.getNombre());
            modeloEmpresa.setUbicacion(empresa.getUbicacion());
            modeloEmpresa.setDescripcion(empresa.getDescripcion());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloEmpresa);
            manejadorConexionEntidades.getTransaction().commit();
            System.out.println("Registro exitoso Empresa");


        }catch (Exception error){
            error.getStackTrace();
            System.out.println(error.getMessage());
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
