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
public class Carrito implements CalculoCompra{

    private ArrayList<Producto> listaProductos;
    int total;

    public Carrito() {
        listaProductos = new ArrayList<>();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        for (Producto p : listaProductos) {
            if (p.nombre.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void agregarProducto(Scanner sc) {
        System.out.println("Ingrese el nombre del produxto: ");
        String n = sc.next();
        boolean existe = this.validarProducto(n);
        if (existe) {
            for (Producto p : listaProductos) {
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
            switch (tipo) {
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

    public void mostrarProducto() {
        for (Producto p : listaProductos) {
            if (p instanceof Carne) {
                Carne ca = (Carne) p;
                System.out.println("nombre carne: " + ca.nombre);
                System.out.println("codigo: " + ca.codigo);
                System.out.println("precio: " + ca.precio);
                System.out.println("tipo corte: " + ca.getTipoCorte());
                System.out.println("subtotal: " + ca.subtotal);

            }
            if (p instanceof Verdura) {
                Verdura ve = (Verdura) p;
                System.out.println("nombre verdura: " + ve.nombre);
                System.out.println("codigo: " + ve.codigo);
                System.out.println("precio: " + ve.precio);
                System.out.println("valor nutricional: " + ve.getValorNutricional());
                System.out.println("subtotal: " + ve.subtotal);

            }
            if (p instanceof Bebestible) {
                Bebestible be = (Bebestible) p;
                System.out.println("nombre bebestible: " + be.nombre);
                System.out.println("codigo: " + be.codigo);
                System.out.println("precio: " + be.precio);
                System.out.println("cantidad ml: " + be.getCantidadMLitros());
                System.out.println("subtotal: " + be.subtotal);

            }
        }

    }

    public void eliminarProducto(String nombre) {
        int h = 0;
        for (Producto p : listaProductos) {
            boolean existe = this.validarProducto(nombre);
            if (existe) {
                h = 1;
                listaProductos.remove(p);
            }
        }

        if (h == 0) {
            System.out.println("El producto no existe");
        } else {
            System.out.println("el producto ha sido eliminado");
        }
    }

    @Override
    public void precioFinalProducto(Producto p, int t) {
        p.subtotal = p.cantidad*p.precio;
        switch (t){
            case 1:
                p.subtotal = p.subtotal - (p.subtotal*(DESCUENTO_CARNE/100));
                break;
            case 3:
                p.subtotal = p.subtotal - (p.subtotal*(DESCUENTO_BEBESTIBLE/100));
                break;
        }
        
    }

    @Override
    public void totalProductos() {
        for (Producto p: listaProductos){
            total += p.subtotal;    
        }
        total = total + (total*(IVA/100));
    }
}
