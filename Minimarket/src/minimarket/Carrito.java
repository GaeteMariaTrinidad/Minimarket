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
public class Carrito implements CalculoCompra {

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
        System.out.println("Ingrese el nombre del producto: ");
        String n = sc.next();
        int htipo = 0;
        boolean existe = this.validarProducto(n);
        if (existe) {
            for (Producto p : listaProductos) {
                if (p.nombre.equals(n)) {
                    p.cantidad += 1;
                    if (p instanceof Carne) {
                        htipo = 1;
                    }
                    if (p instanceof Bebestible) {
                        htipo = 3;
                    }
                    //calculo subtotal
                    precioFinalProducto(p, htipo);

                }
            }
            System.out.println("Se ha sumado 1 al producto que ya estaba en el carrito y esta intentando agregar ("+ n +")");
        } else {
            System.out.println("Ingrese el tipo de producto: 1- Carne 2- Verdura 3- Bebestible");
            int tipo = sc.nextInt();
            System.out.println("Ingrese el código del producto: ");
            int cod = sc.nextInt();
            System.out.println("Ingrese el precio del producto: ");
            int pre = sc.nextInt();
            System.out.println("Ingrese la cantidad del producto: ");
            int cant = sc.nextInt();
            int sub = 0;

            switch (tipo) {
                case 1:
                    System.out.println("Ingrese tipo de corte: ");
                    String tcorte = sc.next();
                    listaProductos.add(new Carne(tcorte, n, cod, pre, cant, sub));
                    htipo = 1;
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
                    htipo = 3;
                    break;
            }

            for (Producto p : listaProductos) {
                if (p.nombre.equals(n)) {
                    precioFinalProducto(p, htipo);
                }
            }
            System.out.println("\nProducto agregado al carrito con éxito!");
        }
        //aquí calcular el subtotal.
    }

    public void mostrarProducto() {
        System.out.println("\nCARRITO DE COMPRA: \n");
        if (listaProductos.size() > 0) {
            for (Producto p : listaProductos) {
                if (p instanceof Carne) {
                    Carne ca = (Carne) p;
                    System.out.println("\nNombre carne: " + ca.nombre);
                    System.out.println("Código: " + ca.codigo);
                    System.out.println("Precio: $" + ca.precio);
                    System.out.println("Cantidad: " + ca.cantidad);
                    System.out.println("Tipo de corte: " + ca.getTipoCorte());
                    System.out.println("Subtotal: $" + ca.subtotal);

                }
                if (p instanceof Verdura) {
                    Verdura ve = (Verdura) p;
                    System.out.println("\nNombre verdura: " + ve.nombre);
                    System.out.println("Código: " + ve.codigo);
                    System.out.println("Precio: " + ve.precio);
                    System.out.println("Cantidad: " + ve.cantidad);
                    System.out.println("Valor nutricional: " + ve.getValorNutricional());
                    System.out.println("Subtotal: $" + ve.subtotal);

                }
                if (p instanceof Bebestible) {
                    Bebestible be = (Bebestible) p;
                    System.out.println("\nNombre bebestible: " + be.nombre);
                    System.out.println("Código: " + be.codigo);
                    System.out.println("Precio: " + be.precio);
                    System.out.println("Cantidad: " + be.cantidad);
                    System.out.println("Cantidad ml: " + be.getCantidadMLitros());
                    System.out.println("Subtotal: $" + be.subtotal);

                }
            }
        } else {
            System.out.println("No hay productos en el carrito");
        }

    }

    public void mostrarProducto(int g, Scanner sc) {

        System.out.println("\nCARRITO DE COMPRA-CHECKOUT: \n");
        if (listaProductos.size() > 0) {
            for (Producto p : listaProductos) {
                if (p instanceof Carne) {
                    Carne ca = (Carne) p;
                    System.out.println("\nNombre carne: " + ca.nombre);
                    System.out.println("Código: " + ca.codigo);
                    System.out.println("Precio: $" + ca.precio);
                    System.out.println("Cantidad: " + ca.cantidad);
                    System.out.println("Tipo de corte: " + ca.getTipoCorte());
                    System.out.println("Subtotal: $" + ca.subtotal);

                }
                if (p instanceof Verdura) {
                    Verdura ve = (Verdura) p;
                    System.out.println("\nNombre verdura: " + ve.nombre);
                    System.out.println("Código: " + ve.codigo);
                    System.out.println("Precio: $" + ve.precio);
                    System.out.println("Cantidad: " + ve.cantidad);
                    System.out.println("Valor nutricional: " + ve.getValorNutricional());
                    System.out.println("Subtotal: $" + ve.subtotal);

                }
                if (p instanceof Bebestible) {
                    Bebestible be = (Bebestible) p;
                    System.out.println("\nNombre bebestible: " + be.nombre);
                    System.out.println("Código: " + be.codigo);
                    System.out.println("Precio: $" + be.precio);
                    System.out.println("Cantidad: " + be.cantidad);
                    System.out.println("Cantidad ml: " + be.getCantidadMLitros());
                    System.out.println("Subtotal: $" + be.subtotal);

                }
            }
            System.out.println("\nEL TOTAL A PAGAR ES DE: $" + total);
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("No hay productos en el Carrito");
        }

    }

    public void eliminarProducto(String nombre) {
        int h = 0;
        for(int i=0; i < listaProductos.size(); i++){
            if(listaProductos.get(i).getNombre().equals(nombre)){
                h=1;
                listaProductos.remove(i);
            }
        }
//        for (Producto p : listaProductos) {
//            if(p.getNombre().equals(nombre)){
//                h=1;
//                listaProductos.remove(p);
//            }
//            
//        }

        if (h == 0) {
            System.out.println("El producto no existe");
        } else {
            System.out.println("el producto ha sido eliminado");
        }
    }

    @Override
    public void precioFinalProducto(Producto p, int t) {
        p.setSubtotal(p.getCantidad() * p.getPrecio());
        switch (t) {
            case 1:
                p.setSubtotal((int) (p.getSubtotal() - (p.getSubtotal() * DESCUENTO_CARNE)));
                break;
            case 3:

                p.setSubtotal((int) (p.getSubtotal() - (p.getSubtotal() * (DESCUENTO_BEBESTIBLE / 100))));
                break;
        }

    }

    @Override
    public void totalProductos() {
        for (Producto p : listaProductos) {
            total += p.getSubtotal();
        }
        total = (int) (total + (total * (IVA / 100)));
    }
}
