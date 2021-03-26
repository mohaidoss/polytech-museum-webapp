package ejb.sessions;

import java.util.Collection;

import javax.persistence.*;
import ejb.entites.*;

@javax.ejb.Stateless
public class ServiceOeuvreBean
implements ServiceOeuvreLocal, ServiceOeuvreRemote	{
@PersistenceContext(unitName="musees")
protected EntityManager em;
	@Override
	public void creerOeuvre(int Id, String URL, String titre, int annee, TypeOeuvre type, int artiste_num)
			throws OeuvreDejaCreeException {
		Oeuvre o = null;
		try{
			o = this.getOeuvre(Id);
			if(o != null)
				throw new OeuvreDejaCreeException();
		} catch (OeuvreInconnueException e){
			if (type == TypeOeuvre.PEINTURE)
				o = new OeuvrePeinture();
			else if (type == TypeOeuvre.PHOTO)
				o = new OeuvrePhoto();
			else if (type == TypeOeuvre.SCULPTURE)
				o = new OeuvreSculpture();
			o.setId(Id);
			o.setURL(URL);
			o.setTitre(titre);
			o.setAnnee(annee);
			o.setAime(0);
			o.setAimepas(0);
			o.setSansavis(0);
			o.setScore();
			try {
				o.setArtiste(this.getArtiste(artiste_num));
			} catch (ArtisteInconnuException e1) {
				System.err.println("Artiste inconnu");
			}
			em.persist(o);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Oeuvre getOeuvre(int Id) throws OeuvreInconnueException {
		Oeuvre o = null;
		o = (Oeuvre) em.find(Oeuvre.class, Id);
		if (o==null)
			throw new OeuvreInconnueException();
		return o;
		/*
		
		*/
	}

	@Override
	public void creerCategorie(String Intitule) throws CategorieDejaCreeException {
		// TODO Auto-generated method stub

		Categorie c = null;
		try{		
			c = this.getCategorie(Intitule);
			if (c!=null)
				throw new CategorieDejaCreeException();
		} catch (CategorieInconnueException e){
			c = new Categorie();
			c.setIntitule(Intitule);
			em.persist(c);
		}
	}

	@Override
	public Categorie getCategorie(String Intitule) throws CategorieInconnueException {
		Categorie c = null;
		c = (Categorie) em.find(Categorie.class, Intitule);
		if (c==null)
			throw new CategorieInconnueException();
		return c;
	}

	@Override
	public void creerArtiste(int Num, String nom, String prenom) throws ArtisteDejaCreeException {
		try{
			this.getArtiste(Num);
			throw new ArtisteDejaCreeException();
		} catch (ArtisteInconnuException e){
			Artiste a = new Artiste();
			a.setNum(Num);
			a.setNom(nom);
			a.setPrenom(prenom);
			em.persist(a);
		}
	}

	@Override
	public Artiste getArtiste(int Num) throws ArtisteInconnuException {
		Artiste a = null;
		a = (Artiste) em.find(Artiste.class, Num);
		if (a==null)
			throw new ArtisteInconnuException();
		return a;
	}

	@Override
	public Collection<Oeuvre> getOeuvres() {
		Collection<Oeuvre> listeOeuvre = (Collection<Oeuvre>) em.createQuery("from Oeuvre").getResultList();
		return listeOeuvre;
	}

	@Override
	public void OeuvreDansCategorie(String IntituleCategorie, int IdOeuvre)
			throws CategorieInconnueException, OeuvreInconnueException, OeuvreDansCategorieException {
		Categorie c = this.getCategorie(IntituleCategorie);
		Oeuvre o = this.getOeuvre(IdOeuvre);
		if (o.getCategories().contains(c))
			throw new OeuvreDansCategorieException();
		o.getCategories().add(c);
		em.persist(o);
	}

	@Override
	public Collection<Categorie> getCategories() {
		Collection<Categorie> listeCategorie = (Collection<Categorie>) em.createQuery("from Categorie").getResultList();
		return listeCategorie;
	}

	@Override
	public Collection<Oeuvre> OeuvreParCategorie(String IntituleCategorie) throws CategorieInconnueException {
		Collection<Oeuvre> resultList = (Collection<Oeuvre>) em.createQuery("select o from Oeuvre where Oeuvre.categories =:intitule").setParameter("intitule", IntituleCategorie).getResultList();
		return resultList;
	}

	@Override
	public void DonnerAvis(int IdOeuvre, Vote avis) throws OeuvreInconnueException {
		Oeuvre o = this.getOeuvre(IdOeuvre);
		if(avis == Vote.AIME)
			o.setAime(o.getAime() + 1);
		else if(avis == Vote.AIMEPAS)
			o.setAimepas(o.getAimepas() + 1);
		else if(avis == Vote.SANSAVIS)
			o.setSansavis(o.getSansavis() + 1);
		o.setScore();
		em.persist(o);
	}

}
