package mainFolder.Ejercicio.DAO.Interface;

import mainFolder.Ejercicio.module.Usuario;
import mainFolder.Ejercicio.module.Usuarioruta;
import mainFolder.Ejercicio.module.UsuariorutaId;

import java.util.List;

public interface IUsuarioRutaDAO {

    Usuario findById(UsuariorutaId id);

    List<Usuarioruta> findAll();

    void create(Usuarioruta usrRt);

    void update(Usuarioruta usrRt);

    void delete(Usuarioruta usrRt);

}
