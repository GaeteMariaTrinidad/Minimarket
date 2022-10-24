/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

import java.util.Scanner;

/**
 *
 * @author Trinidad Gaete
 */
//Clase main
public class Minimarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Variables
        Scanner sc = new Scanner(System.in);
        int op;
        Carrito car = new Carrito();
        
        //Saludo de bienvenida al programa
        System.out.println("¡BIENVENIDO A LA COMPLETA FERIA!");
        //Menú en bucle. El programa no termina hasta que el usuario elija la opción "Salir".
        do {
            
            System.out.println("\n***MENÚ***");
            System.out.println("1.- Agregar productos al carrito");
            System.out.println("2.- Mostrar productos en el carrito");
            System.out.println("3.- Eliminar productos del carrito");
            System.out.println("4.- Realizar compra");
            System.out.println("5.- Salir");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    car.agregarProducto(sc);
                    break;
                case 2:
                    car.mostrarProducto();
                    break;
                case 3:
                    System.out.println("Ingrese nombre del producto a eliminar: ");
                    String n2 = sc.next();
                    car.eliminarProducto(n2);
                    break;
                case 4:
                    car.totalProductos();
                    car.mostrarProducto(1,sc);
                    //car.precioFinalProducto(p, op);
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Debe ingresar una opcion valida del menú");
                    break;
            }
        } while (op != 5);

    }

}
