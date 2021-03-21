package ejb.sessions;

import ejb.entites.*;
import java.util.Collection;

public interface ServiceOeuvre {
	
	//Administrateur
	public void creerOeuvre(int Id,String URL,String titre,int annee,int score,int aime,int aimepas,int sansavis, int artiste_num) throws OeuvreDejaCreeException;
	public Oeuvre getOeuvre(int Id) throws OeuvreInconnueException;
	public void creerCategorie(String Intitule) throws CategorieDejaCreeException;
	public Categorie getCategorie(String Intitule) throws CategorieInconnueException;
	public void creerArtiste(int Num, String nom, String prenom) throws ArtisteDejaCreeException;
	public Artiste getArtiste(int Num) throws ArtisteInconnuException;
	public Collection<Oeuvre> getOeuvres();
	public void OeuvreDansCategorie(String IntituleCategorie,int IdOeuvre) throws CategorieInconnueException, OeuvreInconnueException, OeuvreDansCategorieException;
	//Utilisateur
	public Collection<Categorie> getCategories();
	public Collection<Oeuvre> OeuvreParCategorie(String IntituleCategorie) throws CategorieInconnueException;
	public enum Vote {AIME, AIMEPAS, SANSAVIS};
	public void DonnerAvis(int IdOeuvre, Vote avis) throws OeuvreInconnueException;
}
