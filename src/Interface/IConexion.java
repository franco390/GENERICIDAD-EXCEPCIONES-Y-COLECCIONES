package Interface;
import Exception.ElementoDuplicadoException;
import Exception.ElementoNoEncontradoException;

public interface IConexion<K,E, M> {

    public void agregar(E e) throws ElementoDuplicadoException;
    public void eliminar(K k) throws ElementoNoEncontradoException;
    public E obtener(K k);
    public E obtenerPorMetadato(M m);

}
