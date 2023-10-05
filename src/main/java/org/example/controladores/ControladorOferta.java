package org.example.controladores;

import org.example.entidades.Oferta;
import org.example.servicios.ServicioOferta;

import java.time.LocalDate;

public class ControladorOferta {

    private Oferta oferta = new Oferta();
    private ServicioOferta servicioOferta = new ServicioOferta();

    public void registrarOferta(String titulo, String descripcion, String fechaInicio, String fechaFin,double costoPersona){
        oferta.setTitulo(titulo);
        oferta.setDescripcion(descripcion);
        oferta.setFechaInicio(fechaInicio);
        oferta.setFechaFin(fechaFin);
        oferta.setCostoPersona(costoPersona);
        this.servicioOferta.guardarDatosBD(oferta);



    }
}
