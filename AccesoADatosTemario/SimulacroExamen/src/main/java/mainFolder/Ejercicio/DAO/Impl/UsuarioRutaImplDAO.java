package mainFolder.Ejercicio.DAO.Impl;

import mainFolder.Ejercicio.DAO.Interface.IUsuarioRutaDAO;
import mainFolder.Ejercicio.module.Usuario;
import mainFolder.Ejercicio.module.Usuarioruta;
import mainFolder.Ejercicio.module.UsuariorutaId;

import java.util.List;

public class UsuarioRutaImplDAO implements IUsuarioRutaDAO {

    @Override
    public Usuario findById(UsuariorutaId id) {
        return null;
    }

    @Override
    public List<Usuarioruta> findAll() {
        return List.of();
    }

    @Override
    public void create(Usuarioruta usrRt) {

    }

    @Override
    public void update(Usuarioruta usrRt) {

    }

    @Override
    public void delete(Usuarioruta usrRt) {

    }
}
