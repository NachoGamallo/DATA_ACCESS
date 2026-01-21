package mainFolder.Ejercicio.App;

import mainFolder.Ejercicio.module.Ruta;
import mainFolder.Ejercicio.module.Usuario;
import mainFolder.Ejercicio.module.Usuarioruta;
import mainFolder.Ejercicio.module.UsuariorutaId;
import mainFolder.Ejercicio.config.GestionSesiones;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class CRUD {

    public static void Insert(){

        try (Session session = GestionSesiones.getSessionFactory().openSession()){

            session.beginTransaction();

            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            Ruta r1 = new Ruta();
            Ruta r2 = new Ruta();

            u1.setNombre("Adrian");
            u1.setTelefono("123123123");

            u2.setNombre("Raul");
            u2.setTelefono("321321321");

            r1.setDescripcion("Ruta de san pedro, muy guapa");
            r1.setFecha(LocalDate.parse("2025-12-12"));
            r1.setDuracionHoras(12);

            r2.setDescripcion("La ruta del pescao");
            r2.setFecha(LocalDate.parse("2026-09-19"));
            r2.setDuracionHoras(5);

            session.persist(u1);
            session.persist(u2);
            session.persist(r1);
            session.persist(r2);

            UsuariorutaId id = new UsuariorutaId();
            id.setRutaId(r1.getId());
            id.setUsuarioId(u1.getId());

            //Insert de una excursion.

            Usuarioruta ur = new Usuarioruta();
            ur.setId(id);
            ur.setRuta(r1);
            ur.setUsuario(u1);
            ur.setFechaInscripcion(LocalDate.now());
            ur.setValoracion(5);

            session.persist(ur);

            session.getTransaction().commit();

            System.out.println("Insercion realizada correctamente");

        }catch (Exception e){ e.printStackTrace(); }

    }
    public static void getAllExcursions(){

        System.out.println("Lista de excursiones de los usuarios:");

        try (Session session = GestionSesiones.getSessionFactory().openSession()){

            List <Usuarioruta> list =  session.createQuery("from Usuarioruta", Usuarioruta.class).list();
            list.forEach( u -> System.out.println(u.toString()));


        }catch (Exception e) { e.printStackTrace(); }

    }
    public static void getPerSpecificUser(){

        System.out.println("Lista de usuario en especifico: ");

        try (Session session = GestionSesiones.getSessionFactory().openSession()){

            Usuario usr = session.get(Usuario.class, 19);

            List <Usuarioruta> list =  session.createQuery("from Usuarioruta WHERE usuario = :usuario", Usuarioruta.class)
                    .setParameter("usuario",usr).list();
            list.forEach( u -> System.out.println(u.toString()));


        }catch (Exception e) { e.printStackTrace(); }

    }

}
