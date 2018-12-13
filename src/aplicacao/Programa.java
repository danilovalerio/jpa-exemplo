package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		//Cria os objetos
		Pessoa p1 = new Pessoa(null, "Danilo Valerio da Silva", "danilo@danilo.com");
		Pessoa p2 = new Pessoa(null, "Daniela Veiga Viana", "dani@dani.com");
		Pessoa p3 = new Pessoa(null, "Negrito Preto", "negrito@preto.com");
		*/
		
		//Instancia o emf com as configura��es do persistente.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		/*Com essa instancia��o j� teremos uma conex�o com o banco de dados
		e todo contexto de persistencia implementado*/
		EntityManager em = emf.createEntityManager();
		
		//Quando n�o for simplesmente leitura precisamos de uma transa��o
		em.getTransaction().begin();
		
		/*
		//Para inserir as pessoas no banco de dados
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);		
		em.getTransaction().commit();
		*/
		
		Pessoa p = em.find(Pessoa.class, 3); //Localizar uma pessoa pelo id
		System.out.println(p); //Exibe a pessoa
		
		
		//Para remover
		//em.getTransaction().begin(); //� necess�rio, pois n�o � somente leitura do banco
		em.remove(p); //passa o objetvo a ser removido
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close(); //fecha o EntityManager
		emf.close(); //fecha o EMF
		/*
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);*/
		

	}

}
