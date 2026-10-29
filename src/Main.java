import Model.*;
import Exception.ElementoNoEncontradoException;
import Exception.ElementoDuplicadoException;

import javax.swing.table.TableRowSorter;

public class Main{
    public static void main(String[] args) {

        AlmacenamientoD documento = new AlmacenamientoD();
        AlmacenamientoP producto = new AlmacenamientoP();
        AlmacenamientoU usuario = new AlmacenamientoU();


        Documento d1 = new Documento("Sanchez", "jiji hola", "PABLO SUAREZ");
        Documento d2 = new Documento("Torpedo", "PRINCESA", "LOCOMOTORA");
        Producto p1 = new Producto("PAPAFRITA", "SNACK JEJE", 67.67);
        Producto p2 = new Producto("TAKIS", "SNACK JEJE", 52.67);
        Usuario u1 = new Usuario("PEPE SAND", "JAJAXDXD@GMAIL.COM", "ORASIO2233");
        Usuario u2 = new Usuario("RICARDO FORT", "RICARDITO@GMAIL.COM", "COCO231");

        try {
            documento.agregar(d1);
            documento.agregar(d2);
            System.out.println(documento.obtener(d2.getTitulo()));

        } catch (ElementoDuplicadoException e) {
            System.out.println(e.getMessage());
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            producto.agregar(p1);
            producto.agregar(p2);
            producto.eliminar(p2.getNombre());
            System.out.println(producto.obtener(p1.getNombre()));
        } catch (ElementoDuplicadoException e) {
            System.out.println(e.getMessage());
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            usuario.agregar(u1);
            usuario.agregar(u2);
            System.out.println(usuario.obtener(u2.getEmail()));
            usuario.eliminar(u2.getEmail());
        } catch (ElementoDuplicadoException e) {
            System.out.println(e.getMessage());
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }



}
