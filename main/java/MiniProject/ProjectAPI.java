package MiniProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 * Servlet implementation class ProjectAPI
 */
@WebServlet("/ProjectAPI")
public class ProjectAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String word=(String) request.getParameter("word");
		URL url;
		try {
			
			System.out.println(word);
				 StringBuffer sb = new StringBuffer();
					 url = new URL("https://api.api-ninjas.com/v1/dictionary?word="+word);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestProperty("accept", "application/json");
					connection.setRequestProperty("X-Api-Key","XVClrp0Ngx0WfOu5x5MZGw==Dob1CKsXzHNeI1HF");
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String line;
			    while ((line = reader.readLine()) != null) {
			        sb.append(line);
			        sb.append("\n");
			    }
			    System.out.println(sb+"");
			    
			    JSONParser par=new JSONParser();
				JSONObject jsarr=(JSONObject) par.parse(sb+"");
			response.getWriter().append(jsarr+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
//		doGet(request, response);
	}

}
