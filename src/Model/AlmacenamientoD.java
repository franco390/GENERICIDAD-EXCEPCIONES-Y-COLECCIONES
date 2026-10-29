package Model;

import Interface.IConexion;

import javax.print.Doc;
import javax.swing.*;
import java.util.ArrayList;
import Exception.ElementoDuplicadoException;
import Exception.ElementoNoEncontradoException;

public class AlmacenamientoD implements IConexion<String, Documento, String> {

    private ArrayList<Documento> documento;

    public AlmacenamientoD() {
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

        Documento encontrado = null;

       for (Documento d : documento){

           if (d.getTitulo().equals(clave)){
               encontrado = d;
               break;
           }
       }

       if (encontrado == null){
           throw new ElementoNoEncontradoException();
       }

       documento.remove(encontrado);

    }

    @Override
    public Documento obtener(String doc) throws ElementoNoEncontradoException{

        for (Documento d : documento){

            if (d.getTitulo().equals(doc)){

                return d;
            }
        }

        throw new ElementoNoEncontradoException();

    }

    @Override
    public Documento obtenerPorMetadato(String metedato) throws ElementoNoEncontradoException{

        for (Documento d : documento){

            if (d.getAutor().equals(metedato)){

                return d;
            }
        }

        throw new ElementoNoEncontradoException();

    }
}
