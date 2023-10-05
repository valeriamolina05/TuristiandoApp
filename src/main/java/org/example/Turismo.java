package org.example;

import org.example.controladores.ControladorEmpresa;
import org.example.controladores.ControladorOferta;
import org.example.controladores.ControladorUsuario;
import org.example.entidades.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) {


        Scanner lea = new Scanner(System.in);

        /*ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.registrarUsuario("1234567890", "Valeria Molina", "valemolinac05@gmail.com", 2);

        ControladorEmpresa controladorEmpresa = new ControladorEmpresa();
        controladorEmpresa.registrarEmpresa("1234567890", "Comfama",2, "Descripcion");*/

        ControladorOferta controladorOferta = new ControladorOferta();
        controladorOferta.registrarOferta("Obra de teatro", "Descripción", "02/10/2023", "10/10/2023", 200000);


    }
}