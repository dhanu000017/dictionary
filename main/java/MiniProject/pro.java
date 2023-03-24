package MiniProject;

import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class pro
 */
@WebServlet("/pro")
public class pro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pro() {
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
		URL url1;
		try {
					 url1 = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word);
					HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
					InputStream responseStream = connection.getInputStream();
					String line="";
					Scanner sc=new Scanner(responseStream);
					while(sc.hasNext()) {
						line+=sc.next();
					}
					System.out.println(line);
					  JSONParser par1=new JSONParser();
					  JSONArray jsarr1=(JSONArray) par1.parse(line+"");
					response.getWriter().append(jsarr1+"");
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("hu");
			e.printStackTrace();
		}	
//		doGet(request, response);
	}

}
