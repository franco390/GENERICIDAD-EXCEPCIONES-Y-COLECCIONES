package Model;

import Interface.IConexion;

import java.util.HashSet;
import Exception.ElementoDuplicadoException;
import Exception.ElementoNoEncontradoException;

public class AlmacenamientoU implements IConexion <String, Usuario, String> {

    private HashSet<Usuario> setUsuarios;

    public AlmacenamientoU() {
        this.setUsuarios = new HashSet<>();
    }

    @Override
    public void agregar(Usuario usuario) throws ElementoDuplicadoException {

        for (Usuario u : setUsuarios){

            if (u.getEmail().equals(usuario.getEmail())){

                throw new ElementoDuplicadoException();
            }
        }

        setUsuarios.add(usuario);

    }

    @Override
    public void eliminar(String clave) throws ElementoNoEncontradoException {

        Usuario encontrado = null;

        for (Usuario u : setUsuarios){

            if (u.getEmail().equals(clave)){

                encontrado = u;
                break;
            }
        }

        if (encontrado == null){

            throw new ElementoNoEncontradoException();
        }

        setUsuarios.remove(encontrado);

    }

    @Override
    public Usuario obtener(String email) throws ElementoNoEncontradoException{

        for (Usuario u : setUsuarios){

            if (u.getEmail().equals(email)){

                return u;
            }
        }

        throw new ElementoNoEncontradoException();
    }

    @Override
    public Usuario obtenerPorMetadato(String nombreUsuario) throws ElementoNoEncontradoException {

        for (Usuario u : setUsuarios){

            if (u.getNombreUsuario().equals(nombreUsuario)){

                return u;
            }
        }
        throw new ElementoNoEncontradoException();
    }
}
