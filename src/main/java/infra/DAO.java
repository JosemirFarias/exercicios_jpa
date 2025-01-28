package infra;

import jakarta.persistence.*;

import java.util.List;

public class DAO <E> {

    private static EntityManagerFactory emf;
    private final EntityManager em;
    private final Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios_jpa");
        } catch (Exception ignored) {
        }
    }
    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTansacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTansacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir (E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirMultiplos (E entidade) {
        return this.abrirTansacao().incluir(entidade).fecharTansacao();
    }

    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public List<E> obterTodos(int qtde, int deslocamneto) {
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula");
        }
        String jpql = "select e from "+ classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamneto);
        return query.getResultList();
    }

    public void fechar() {
        em.close();
    }
}
