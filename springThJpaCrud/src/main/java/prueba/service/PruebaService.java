package prueba.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prueba.entidad.PruebaEntity;
 
@Service
public class PruebaService {
   
  // An EntityManager will be automatically injected from EntityManagerFactory setup on
  // spring-context.xml
  @PersistenceContext
  private EntityManager em;
   
  // Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
  // any bean method annotated with @Transactional will cause Spring to magically call
  // begin() and commit() at the start/end of the method. If exception occurs it will also
  // call rollback()
  @Transactional(readOnly = true)
  public List<PruebaEntity> getAll() {
    List<PruebaEntity> result = em.createQuery("SELECT p FROM PruebaEntity p", PruebaEntity.class).getResultList();
    return result;
  }
   
  @Transactional
  public void add(PruebaEntity p) {
    em.persist(p);
  }

  @Transactional
public void remove(PruebaEntity p) {
	em.remove(em.find(PruebaEntity.class, p.getId())); // se hace find evitar problema de objeto detached
	
}

  @Transactional
public void updatePrueba(PruebaEntity p) {
	  
	em.merge(p); //es autocommit
	
}
}