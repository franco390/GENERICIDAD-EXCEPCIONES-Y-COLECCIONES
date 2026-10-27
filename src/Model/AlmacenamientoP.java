package Model;

import Interface.IConexion;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import Exception.ElementoNoEncontradoException;
import Exception.ElementoDuplicadoException;

public class AlmacenamientoP<K, E, M> implements IConexion <String, Producto, String> {

    private Map<String, Producto> mapaProducto;

    public AlmacenamientoP() {
        this.mapaProducto = new HashMap<>();
    }


    @Override
    public void agregar(Producto producto) throws ElementoDuplicadoException {

        String clave = producto.getNombre();

        if (mapaProducto.containsKey(clave)){

            throw new ElementoDuplicadoException();
        }
        mapaProducto.put(clave, producto);

    }

    @Override
    public void eliminar(String s) throws ElementoNoEncontradoException {

    }

    @Override
    public Producto obtener(Producto producto) {
        return null;
    }

    @Override
    public Producto obtenerPorMetadato(String s) {
        return null;
    }
}
