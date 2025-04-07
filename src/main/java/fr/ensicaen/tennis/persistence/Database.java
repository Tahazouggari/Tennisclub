package fr.ensicaen.tennis.persistence;

//import fr.ensicaen.tennis.exception.AuthenticationException;
//import fr.ensicaen.tennis.utils.PwdUtils;
import fr.ensicaen.tennis.security.XSSRequestWrapper;
import fr.ensicaen.tennis.ApplicationProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author JRD
 * @see <a href="https://javadoc.io/doc/jakarta.persistence/jakarta.persistence-api/3.0.0/jakarta.persistence/module-summary.html">Jakarta Persistence API</a>
 */
public class Database {
	private static Database instance;
	private EntityManager entityManager;

	public static Database getInstance() {
		if (instance == null) instance = new Database();
		return instance;
	}

	protected Database() {
		final String db_unit_name = ApplicationProperties.get("tennis");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(db_unit_name);
//		System.out.println("ENTITY MANAGER FACTORY PROPERTIES");
//		Map<String, Object> properties = emf.getProperties();
//		properties.keySet().stream().filter(s -> s.contains("javax.persistence.jdbc")).forEach(k -> System.out.println(k+"="+properties.get(k)));
//		System.out.println("----------------------------------");
		entityManager = emf.createEntityManager();
	}

	public void close() {
		if (entityManager != null) entityManager.close();
	}

	/**
	 * Anti-injection method.
	 */
	public static String XSSReplacer(String s) {
		for (Pattern scriptPattern : XSSRequestWrapper.patterns){
			s = scriptPattern.matcher(s).replaceAll("");
		}
		return s;
	}

	// ********** TODOLIST **********

	public List<TodoEntity> listTodo() {
		final Query query = entityManager.createQuery("from TodoEntity t");
		return query.getResultList();
	}

	public TodoEntity getTodoById(int id) {
		final Query query = entityManager.createQuery("from TodoEntity t where t.idTodo = :id");
		query.setParameter("id", id);
		return (TodoEntity)query.getSingleResult();
	}

	public TodoEntity addTodoByDescription(String description) {
		if (description == null || description.isEmpty()) return null;
		TodoEntity todo = new TodoEntity();
		todo.setDescription(XSSReplacer(description));
		entityManager.getTransaction().begin();
		entityManager.persist(todo);
		entityManager.getTransaction().commit();
		return todo;
	}

	// 🔍 Récupérer un adhérent par email (pour login)
	public AdherentEntity getAdherentByEmail(String email) {
		if (email == null || email.isEmpty()) return null;
		Query query = entityManager.createQuery("FROM Adherent a WHERE a.email = :email");
		query.setParameter("email", email);
		try {
			return (AdherentEntity) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}


}
