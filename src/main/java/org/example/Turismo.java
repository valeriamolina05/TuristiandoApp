package org.example;

import org.example.entidades.Local;
import org.example.entidades.Oferta;
import org.example.entidades.Reserva;
import org.example.entidades.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        Local local = new Local();
        Oferta oferta = new Oferta();
        Reserva reserva = new Reserva();

        Scanner lea = new Scanner(System.in);

        System.out.println("\u001B[34m--------Bienvenido(a)---------\u001B[0m");

        System.out.println("\n\u001B[35m1. Datos del usuario: \u001B[0m");
        System.out.print("Por favor, ingrese su nombre y apellido: ");
        usuario.setNombres(lea.nextLine());
        System.out.println("Ingrese su correo electrónico: ");
        usuario.setCorreo(lea.nextLine());
        System.out.println("Ingrese su ubicación: \n1. Centro \n2. Sur \n3. Norte \n4. Otras ");
        usuario.setUbicacion(Integer.parseInt(lea.nextLine()));
        usuario.setId();
        System.out.println("El id del usuario es: " + usuario.getId());

        System.out.println("\n\u001B[35m2. Datos del local: \u001B[0m");
        System.out.println("Por favor, ingrese el nombre de su local: ");
        local.setNombre(lea.nextLine());
        System.out.println("Ingrese el NIT de su local: ");
        local.setNit(lea.nextLine());
        local.setId();
        System.out.println("El id de su local es: " + local.getId());

        System.out.println("\n\u001B[35m3. Datos de la oferta: \u001B[0m");
        System.out.println("Ingrese el título de la oferta: ");
        oferta.setTitulo(lea.nextLine());
        System.out.println("¿Cuál es la fecha de inicio de la oferta? ");
        oferta.setFechaInicio(lea.nextLine());
        System.out.println("¿Cuál es la fecha de fin de la oferta? ");
        oferta.setFechaFin(lea.nextLine());
        System.out.println("¿Cuál es el costo por persona? ");
        oferta.setCostoPersona(lea.nextDouble());
        lea.nextLine();
        oferta.setId();
        System.out.println("El id de la oferta es: " + oferta.getId());

        System.out.println("\n\u001B[35m4. Datos de la reserva: \u001B[0m");
        System.out.println("Ingrese la fecha para realizar la reserva: ");
        reserva.setFechaReserva(lea.nextLine());
        System.out.println("Ingrese el número de personas para la reserva: ");
        reserva.setNumeroPersonas(Integer.parseInt(lea.nextLine()));
        reserva.setId();
        System.out.println("El id de la reserva es: " + reserva.getId());
        reserva.setCostoTotal(oferta.getCostoPersona() * reserva.getNumeroPersonas());
        System.out.println("El costo total de la reserva es: " + reserva.getCostoTotal());


        System.out.println("\u001B[34m-----------------------//------------------------\u001B[0m");
        System.out.println("\u001B[35mSu nombre y apellido son: \u001B[0m" + usuario.getNombres());
        System.out.println("\u001B[35mEl Nit del local es: \u001B[0m" + local.getNit());
        System.out.println("\u001B[35mEl Nombre del local es: \u001B[0m" + local.getNombre());
        System.out.println("\u001B[35mEl titulo de la oferta es: \u001B[0m" + oferta.getTitulo());
        System.out.println("\u001B[35mLa fecha de inicio es: \u001B[0m" + oferta.getFechaInicio());
        System.out.println("\u001B[35mLa fecha de fin es: \u001B[0m" + oferta.getFechaFin());
        System.out.println("\u001B[35mEl valor de la oferta es: \u001B[0m" + oferta.getCostoPersona());
        System.out.println("\u001B[35mLa fecha de la reserva es: \u001B[0m" + reserva.getFechaReserva());
        System.out.println("\u001B[35m: \u001B[0m" );





    }
}