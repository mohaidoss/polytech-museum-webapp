package client;

import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.entites.*;
import ejb.sessions.*;

public class Main {
   static String urlDoisneau1="https://media.timeout.com/images/103443148/750/422/image.jpg" ;
   static String urlDoisneau2="http://www.christies.com/lotfinderimages/d42621/d4262145r.jpg" ;
   static String urlDoisneau3="http://www.artnet.fr/WebServices/images/ll1308426llgM4JCfDrCWvaHBOAD/robert-doisneau-le-fox-terrier-au-pont-des-arts.jpg" ;
   static String urlVermeer1="https://cdn.radiofrance.fr/s3/cruiser-production/2016/05/5791f11c-4124-45b9-b493-2bd99aace836/838_meisje_met_de_parel.webp" ;
   static String urlVermeer2="http://chrisdesbaumes.files.wordpress.com/2012/10/la-laitic3a8re-de-vermeer.jpg" ;
   static String urlBrancusi1="https://lireditelle.files.wordpress.com/2018/09/baiser01.jpg" ;
   static String urlKlimt1="https://blog.artsper.com/wp-content/uploads/2019/02/le-baiser-klimt-sized.jpg";
	
	public static void main(String[] args) {
	  
		try {
			InitialContext ctx = new InitialContext();
			System.out.println("Accès au service distant") ;
			String adresse = "ejb:musees/museesSessions//ServiceOeuvreBean!ejb.sessions.ServiceOeuvreRemote";
			Object obj = ctx.lookup(adresse);
			
			ServiceOeuvreRemote service = (ServiceOeuvreRemote) obj;
			try{
				service.creerArtiste(1, "Doisneau", "Robert");
				service.creerArtiste(2, "Vermeer", "Johanees");
				service.creerArtiste(3, "Brancusi", "Constantin");
				service.creerArtiste(4, "Klimt", "Gustav");
				service.creerOeuvre(1, urlDoisneau1, "Le baiser de l'hotel de ville", 1950, ServiceOeuvreRemote.TypeOeuvre.PHOTO,1);
				service.creerOeuvre(2, urlDoisneau2, "L'information scolaire", 1956, ServiceOeuvreRemote.TypeOeuvre.PHOTO, 1);
				service.creerOeuvre(3, urlDoisneau3, "Fox-terrier au pont des Arts", 1953, ServiceOeuvreRemote.TypeOeuvre.PHOTO, 1);
				service.creerOeuvre(4, urlVermeer1, "La jeune fille à la perle", 1665, ServiceOeuvreRemote.TypeOeuvre.PEINTURE, 2);
				service.creerOeuvre(5, urlKlimt1, "Le baiser", 1909, ServiceOeuvreRemote.TypeOeuvre.PEINTURE, 4);
				service.creerOeuvre(6, urlVermeer2, "La laitière", 1665, ServiceOeuvreRemote.TypeOeuvre.PEINTURE, 2);
				service.creerOeuvre(7, urlBrancusi1, "Le baiser", 1909, ServiceOeuvreRemote.TypeOeuvre.SCULPTURE, 3);
				service.creerCategorie("Paris");
				service.creerCategorie("Personnages");
				service.creerCategorie("Noir et Blanc");
				service.creerCategorie("Baiser");
				service.creerCategorie("Portrait");
				service.creerCategorie("Travail");
				service.OeuvreDansCategorie("Paris", 1);
				service.OeuvreDansCategorie("Personnages",1);
				service.OeuvreDansCategorie("Noir et Blanc",1);
				service.OeuvreDansCategorie("Baiser",1);
				service.OeuvreDansCategorie("Personnages",2);
				service.OeuvreDansCategorie("Noir et Blanc",2);
				service.OeuvreDansCategorie("Personnages",3);
				service.OeuvreDansCategorie("Noir et Blanc",3);
				service.OeuvreDansCategorie("Paris",3);
				service.OeuvreDansCategorie("Portrait",4);
				service.OeuvreDansCategorie("Personnages",4);
				service.OeuvreDansCategorie("Travail",5);
				service.OeuvreDansCategorie("Personnages",5);
				service.OeuvreDansCategorie("Personnages",6);
				service.OeuvreDansCategorie("Personnages",7);
				service.OeuvreDansCategorie("Baiser",7);
				
			} catch(ArtisteDejaCreeException e) {
				System.err.println("Artiste existant");
			} catch(OeuvreDejaCreeException e) {
				System.err.println("Oeuvre existante");
			} catch(CategorieDejaCreeException e) {
				System.err.println("Categorie existante");
			} catch(OeuvreInconnueException e) {
				System.err.println("Oeuvre inconnue");
			} catch (CategorieInconnueException e) {
				System.err.println("CategorieInconnue");
			} catch (OeuvreDansCategorieException e) {
				System.err.println("Oeuvre déjà associer à la catégorie");
			}
			for(Oeuvre o : service.getOeuvres()){
				System.out.println("----------" +
						 o.getTitre() + " - " + o.getArtiste().getNom() + " " + o.getArtiste().getPrenom() +" ["+o.getAnnee()+"] ");
				for(Categorie c :o.getCategories()){
					System.out.printf(c.getIntitule()+",");
				}
				System.out.printf("\n");
			}
	    } catch(NamingException e0) {
	        System.err.println("Erreur:"+e0.getMessage() ) ;
		}
	}
}
