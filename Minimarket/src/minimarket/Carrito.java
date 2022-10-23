/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Trinidad Gaete
 */
public class Carrito {

    private ArrayList<Producto> listaProductos;

    public Carrito() {
        listaProductos = new ArrayList<>();
    }
    
    public Carrito(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    /**
     * @return the listaProductos
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
   
    public boolean validarProducto(String nombre) {
        for (Producto p: listaProductos) {
            if (p.nombre.equals(nombre)) {
                return true;        
            }  
        }
        return false;
    } 
    
    public void agregarProducto(Scanner sc){
        System.out.println("Ingrese el nombre del produxto: ");
        String n = sc.next();
        boolean existe = this.validarProducto(n);
        if(existe) {
            for (Producto p: listaProductos) {
                if (p.nombre.equals(n)) {
                    p.cantidad += 1;
                }
            }
        } else {
            System.out.println("Ingrese el código del producto: ");
            int cod = sc.nextInt();
            System.out.println("Ingrese el precio del producto: ");
            int pre = sc.nextInt();
            System.out.println("Ingrese la cantidad del procuto: ");
            int cant = sc.nextInt();
            int sub = 0;   
            System.out.println("Tipo producto: 1- Carne \n 2- Verdura \n 3- Bebestible");
            int tipo = sc.nextInt();
            switch (tipo){
                case 1:
                    System.out.println("Ingrese tipo de corte: ");
                    String tcorte = sc.next();
                    listaProductos.add(new Carne(tcorte, n, cod, pre, cant, sub));
                    break;
                
                case 2:
                    System.out.println("Ingrese valor nutricional: ");
                    String vn = sc.next();
                    listaProductos.add(new Verdura(vn, n, cod, pre, cant, sub));
                    break;
                    
                case 3:
                    System.out.println("Ingrese cantidad de ml: ");
                    int ml = sc.nextInt();
                    listaProductos.add(new Bebestible(ml, n, cod, pre, cant, sub));
                    break;
            }
        }
        //aquí calcular el subtotal.
    }
    
    
    
    
    
}
