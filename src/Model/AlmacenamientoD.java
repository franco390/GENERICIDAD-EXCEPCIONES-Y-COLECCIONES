package Model;

import Interface.IConexion;

import javax.swing.*;
import java.util.ArrayList;
import Exception.ElementoDuplicadoException;
import Exception.ElementoNoEncontradoException;

public class AlmacenamientoD<K, E, M> implements IConexion<String, Documento, String> {

    private ArrayList<Documento> documento;

    public AlmacenamientoD(ArrayList<Documento> documento) {
        this.documento = new ArrayList<>();
    }


    @Override
    public void agregar(Documento doc) throws ElementoDuplicadoException {

        for (Documento d : documento){
            if (d.getTitulo().equals(doc.getTitulo())){

                throw new ElementoDuplicadoException();

            }
        }

        documento.add(doc);

    }

    @Override
    public void eliminar(String clave) throws ElementoNoEncontradoException {
       if (!documento.contains(clave)){

           throw new ElementoNoEncontradoException();
       }

       documento.remove(clave);

    }

    @Override
    public Documento obtener(Documento doc) throws ElementoNoEncontradoException{

        for (Documento d : documento){

            if (d.getTitulo().equals(doc.getTitulo())){

                return d;
            }
        }

        throw new ElementoNoEncontradoException();

    }

    @Override
    public Documento obtenerPorMetadato(String clave) throws ElementoNoEncontradoException{

        for (Documento d : documento){

            if (d.getTitulo().equals(clave)){

                return d;
            }
        }

        throw new ElementoNoEncontradoException();

    }
}
