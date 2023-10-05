package org.example.controladores;

import org.example.entidades.Empresa;
import org.example.servicios.ServicioEmpresa;

public class ControladorEmpresa {

    private Empresa empresa = new Empresa();
    private ServicioEmpresa servicioEmpresa = new ServicioEmpresa();
    public void registrarEmpresa(String nit, String nombre, Integer ubicacion, String descripcion){
        empresa.setNit(nit);
        empresa.setNombre(nombre);
        empresa.setUbicacion(ubicacion);
        empresa.setDescripcion(descripcion);
        this.servicioEmpresa.guardarDatosBD(empresa);

    }
}
