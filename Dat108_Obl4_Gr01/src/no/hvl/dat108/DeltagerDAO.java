package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class DeltagerDAO {

	@PersistenceContext(name = "DeltagerPU")
	EntityManager em;
	
	public void lagreNyDeltager(Deltager nyDeltager) {
		
		em.persist(nyDeltager);
	}
	
	
	public List<Deltager> hentAlleDeltagere() {
		
		return em.createQuery("SELECT f FROM Deltager f"
				+ " ORDER BY f.fornavn, f.etternavn",Deltager.class).getResultList();
	}
	
	public Deltager hentDeltager(Integer mobil) {
		
		return em.find(Deltager.class, mobil);
	}
}
