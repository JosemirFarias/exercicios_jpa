package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios_jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 1L);

        em.detach(usuario); // Comando responsável por tirar o objeto do estado gerenciado.
        // Com isso os dados so seram atualizados com o uso do em.merge.

        usuario.setNome("Josemir");
        usuario.setEmail("josemir@gmail.com");

        em.merge(usuario); // Comando para fazer o update no banco de dados.

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
