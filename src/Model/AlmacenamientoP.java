package Model;

import Interface.IConexion;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import Exception.ElementoNoEncontradoException;
import Exception.ElementoDuplicadoException;


public class AlmacenamientoP implements IConexion <String, Producto, String> {

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
    public void eliminar(String clave) throws ElementoNoEncontradoException{

        if (!mapaProducto.containsKey(clave)){
            throw new ElementoNoEncontradoException();
        }

        mapaProducto.remove(clave);
    }

    @Override
    public Producto obtener(String clave) throws ElementoNoEncontradoException{

        if (!mapaProducto.containsKey(clave)){
            throw new ElementoNoEncontradoException();
        }

         return mapaProducto.get(clave);
    }

    @Override
    public Producto obtenerPorMetadato(String metadato) throws ElementoNoEncontradoException{

        for (Producto p : mapaProducto.values()){

            if (p.getCategoria().equals(metadato)){

                return p;
            }
        }

        throw new ElementoNoEncontradoException();
    }
}
