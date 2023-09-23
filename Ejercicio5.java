/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboratorio;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Ejercicio5 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDias = 6;
        double ventasTotales = 0.0;

        
        boolean inputValido = false;
        while (!inputValido) {
            try {
                System.out.print("¿Para cuántos días tienes cifras de ventas? ");
                totalDias = scanner.nextInt();
                if (totalDias >= 1) {
                    inputValido = true;
                } else {
                    System.out.println("El número de días debe ser mayor o igual a 1. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                scanner.nextLine(); 
            }
        }

        
        for (int dia = 1; dia <= totalDias; dia++) {
            inputValido = false;
            while (!inputValido) {
                try {
                    System.out.print("Ingrese las ventas para el día " + dia + ": ");
                    double ventasDia = scanner.nextDouble();
                    if (ventasDia >= 0) {
                        ventasTotales += ventasDia;
                        inputValido = true;
                    } else {
                        System.out.println("Las ventas no pueden ser negativas. Intente nuevamente.");
                    }
                } catch (Exception e) {
                    System.out.println("Disculpa, el número ingresado es incorrecto. Ingrese un número mayor o igual a 1.");
                    scanner.nextLine();
                }
            }
        }

      
        System.out.printf("Las ventas totales son S/ %.2f%n", ventasTotales);

       
        scanner.close();

       
        System.exit(0);
    }
}
    
