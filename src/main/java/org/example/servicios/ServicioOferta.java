package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.Empresa;
import org.example.entidades.Oferta;
import org.example.modelos.ModeloOferta;

public class ServicioOferta {

    public void guardarDatosBD(Oferta oferta){

        String persistenciaNombre = "conexionbd";
        EntityManagerFactory conexionEntidades = null;
        EntityManager manejadorConexionEntidades = null;

        try {
            conexionEntidades = Persistence.createEntityManagerFactory(persistenciaNombre);
            manejadorConexionEntidades=conexionEntidades.createEntityManager();

            ModeloOferta modeloOferta = new ModeloOferta();

            modeloOferta.setTitulo(oferta.getTitulo());
            modeloOferta.setDescripcion(oferta.getDescripcion());
            modeloOferta.setFechaInicio(oferta.getFechaInicio());
            modeloOferta.setFechaFin(oferta.getFechaFin());
            modeloOferta.setCostoPersona(oferta.getCostoPersona());

            manejadorConexionEntidades.getTransaction().begin();
            manejadorConexionEntidades.persist(modeloOferta);
            manejadorConexionEntidades.getTransaction().commit();

            System.out.println("Registro exitoso Oferta");
        }catch(Exception error){
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
}

