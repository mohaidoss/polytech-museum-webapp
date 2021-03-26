package web.controleurs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ejb.sessions.* ;
import ejb.sessions.ServiceOeuvre.Vote;

import ejb.entites.* ;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(value={"vueOeuvres","vueCategorie","avis"})
public class Controleur extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @javax.ejb.EJB private ServiceOeuvreLocal service;
  
  
  public Controleur() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    String url = request.getRequestURL().toString();
    String maVue="/vueCategorie.jsp" ;
    if(url.endsWith("/vueCategorie")){
            maVue="/vueCategorie.jsp" ;
           Collection<Categorie> categorie = service.getCategories();
           request.setAttribute("Categories", categorie);
    }else if(url.endsWith("/vueOeuvres")){
            maVue="/vueOeuvres.jsp";
            String intitule=request.getParameter("categ");
            Collection<Oeuvre> oeuvre;
            try {
            	oeuvre = service.OeuvreParCategorie(intitule);
            }
            catch (Exception e){
            	oeuvre = service.getOeuvres();
            }
            request.setAttribute("Categories", intitule);
            request.setAttribute("oeuvre", oeuvre);
            
            
    } else if(url.endsWith("/avis")){
    	
    	String avisGet = request.getParameter("avis");
    	String idGet = request.getParameter("id");
    	int id = Integer.parseInt(idGet);
    	System.out.println(avisGet + " " + id);
    	Vote res;
    	if (avisGet.equals("1"))
    		res = Vote.AIME;
    	else if (avisGet.equals("2"))
    		res = Vote.AIMEPAS;
    	else
    		res = Vote.SANSAVIS;
    	String message;
    	try{
    		service.DonnerAvis(id, res);
    		message = "Confirmation du vote sur l'oeuvre " + service.getOeuvre(id).getTitre();
    	} catch (OeuvreInconnueException e) {
    		message = "Oeuvre inconnue" + idGet;
    	}
        String intitule=request.getParameter("categ");
    	Collection<Oeuvre> oeuvre;
    	try {
        	oeuvre = service.OeuvreParCategorie(intitule);
        }
        catch (Exception e){
        	oeuvre = service.getOeuvres();
        }
    	maVue="/vueOeuvres?categ=" + intitule;
        request.setAttribute("oeuvre", oeuvre);
    	request.setAttribute("message", message);
    }
	
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(maVue);
    dispatcher.forward(request,response);
  }
}
