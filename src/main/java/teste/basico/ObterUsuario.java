package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class ObterUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 3L);
        System.out.println(usuario.getNome());

        em.close();
        emf.close();
    }
}
