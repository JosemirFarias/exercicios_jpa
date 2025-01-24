package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class RemoverUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 5L);

        if (usuario != null) {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }
}
