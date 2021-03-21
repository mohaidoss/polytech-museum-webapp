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
				service.creerOeuvre(1, urlDoisneau1, "Le baise de l'hotel de ville", 1950, 0, 0, 0, 0,1);
			} catch(ArtisteDejaCreeException e) {
				System.err.println("Artiste existant");
			} catch(OeuvreDejaCreeException e) {
				System.err.println("Oeuvre existante");
			} /*catch(ArtisteInconnuException e) {
				System.err.println("Artiste inconnu");
			} catch(OeuvreInconnueException e) {
				System.err.println("Oeuvre inconnue");
			}*/
			for(Oeuvre o : service.getOeuvres()){
				System.out.println("----------" +
						 o.getTitre() + "--------" + o.getArtiste().getNom());
			}
	    } catch(NamingException e0) {
	        System.err.println("Erreur:"+e0.getMessage() ) ;
		}
	}
}
