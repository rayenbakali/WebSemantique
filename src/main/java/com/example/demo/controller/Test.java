package com.example.demo.controller;

import java.io.ByteArrayOutputStream;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tools.JenaEngine;

//import com.example.demo.tools.JenaEngine;


 




@RestController

@RequestMapping("/test")


@CrossOrigin(origins = "http://localhost:3001")
public class Test {
	@GetMapping("/hello")
    public String getAllToursByTitler() {

       return "hello";
    }
	
	
	@GetMapping("/etudiant/{name}")
    public String getEtudiantByName(@PathVariable(value = "name") String name) {

        String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?CIN ?NAME ?AGE ?EMAIL\n" +
                "WHERE {\n" +
                "?ETUDIANT ns:CIN ?CIN ;\n" +
                "             ns:NAME ?NAME ;\n" +
                "             ns:AGE ?AGE ;\n" +
                "             ns:EMAIL ?EMAIL ;\n" +
               
                 "FILTER ( ( ?NAME = '"+name+"' )  ) " +
                "}";

        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }

	@GetMapping("/etudiants")
    public String getEtudiant() {

        String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?CIN ?NAME ?AGE ?EMAIL\n" +
                "WHERE {\n" +
                "?ETUDIANT ns:CIN ?CIN ;\n" +
                "             ns:NAME ?NAME ;\n" +
                "             ns:AGE ?AGE ;\n" +
                "             ns:EMAIL ?EMAIL ;\n" +
               
                
                "}";

        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/Cours")
    public String getCours() {

        String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?TITLE ?VIDEO ?PDF\n" +
                "WHERE {\n" +
                "?COURS ns:TITLE ?TITLE ;\n" +
                "             ns:VIDEO ?VIDEO ;\n" +
                "             ns:PDF ?PDF ;\n" +
             
               
                
                "}";

        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
 
	@GetMapping("/centreformations")
    public String getCF() {

        String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT *\n" +
                "WHERE {\n" +
                "?CENTRE_DE_FORMATION ns:NAME ?NAME ;\n" +
                "             ns:ADRESS ?ADRESS ;\n" +
                "             ns:EMAIL ?EMAIL ;\n" +
                "             ns:NUMTEL ?NUMTEL ;\n" +
                
             
               
                
                "}";

        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/posts")
    public String getPOST() {

        String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT *\n" +
                "WHERE {\n" +
                "?POSTS ns:POST_ID ?POST_ID ;\n" +
             
             
               
                
                "}";

        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	
	
	@GetMapping("/admincentre")
    public String getadmincentre() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?ADMIN ?CENTRE_DE_FORMATION \n" +
                "WHERE {\n" +
                "?CENTRE_DE_FORMATION ns:DIRIGER_PAR ?ADMIN ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/etudiantevent")
    public String getaetudiantevent() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?EVENT ?ETUDIANT \n" +
                "WHERE {\n" +
                "?ETUDIANT ns:PARTICIPER_à ?EVENT ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/etudiantreclamation")
    public String getaetudiantreclamation() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?RECLAMATION ?ETUDIANT \n" +
                "WHERE {\n" +
                "?ETUDIANT ns:AFFECTER_DES ?RECLAMATION ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	
	@GetMapping("/formationetu")
    public String getformationetu() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?FORMATION ?ETUDIANT \n" +
                "WHERE {\n" +
                "?ETUDIANT ns:ASSISTER_à ?FORMATION ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/coursposts")
    public String getcoursposts() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?COURS ?POSTS \n" +
                "WHERE {\n" +
                "?COURS ns:CONTIENT_DES ?POSTS ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
 
	
	@GetMapping("/centreconference")
    public String getcentreconference() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?CONFERENCE ?CENTRE_DE_FORMATION \n" +
                "WHERE {\n" +
                "?CONFERENCE ns:ORGANISER_PAR ?CENTRE_DE_FORMATION ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/etudiantseminaire")
    public String getetudiantseminaire() {
		
		
		String qexec = "PREFIX ns: <http://www.owl-ontologies.com/sem.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?SEMINAIRE ?ETUDIANT \n" +
                "WHERE {\n" +
                "?ETUDIANT ns:PARTICIPER_à ?SEMINAIRE ;\n" +
          
                "}";

        
        Model model = JenaEngine.readModel("data/sem.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
 
 
 
	
	
 


}
