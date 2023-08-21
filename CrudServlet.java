package Package;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/CrudServlet")
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db=new Database();
		ArrayList<Employee> data=db.getEmployees();
		String btn=request.getParameter("button");
		if(btn.equals("First")) {
			JSONObject jo=new JSONObject();
			Employee e=data.get(0);
			jo.put("name",e.getName());
			jo.put("eno",e.getEno());
			jo.put("sal",e.getSal());
			jo.put("job",e.getJob());
			jo.put("dept",e.getDept());
			response.getWriter().write(jo.toString());
		}
		else if(btn.equals("Last")) {
			JSONObject jo=new JSONObject();
			Employee e=data.get(data.size()-1);
			jo.put("name",e.getName());
			jo.put("eno",e.getEno());
			jo.put("sal",e.getSal());
			jo.put("job",e.getJob());
			jo.put("dept",e.getDept());
			response.getWriter().write(jo.toString());
		}
		else if(btn.equals("Next") || btn.equals("Prev")) {
			JSONObject jo=new JSONObject();
			int pos=Integer.parseInt(request.getParameter("pos"));
			Employee e=data.get(pos);
			jo.put("name",e.getName());
			jo.put("eno",e.getEno());
			jo.put("sal",e.getSal());
			jo.put("job",e.getJob());
			jo.put("dept",e.getDept());
			response.getWriter().write(jo.toString());
		}
		else if(btn.equals("Add")) {
			String s1=request.getParameter("s1");
			String s2=request.getParameter("s2");
			String s3=request.getParameter("s3");
			String s4=request.getParameter("s4");
			String s5=request.getParameter("s5");
			Employee e=new Employee(s1,s2,s3,s4,s5);
			db.addEmployee(e);
		}
		else if(btn.equals("Delete")) {
			int g=-1;
			String eno=request.getParameter("eno");
			for(int i=0;i<data.size();i++) {
				if(data.get(i).getEno().equals(eno)) {
					g=i;
					break;
				}
			}
			data.remove(g);
			db.deleteEmployee(eno);
			response.getWriter().write("");
			
		}
		else if(btn.equals("Edit")) {
			String s1=request.getParameter("s1");
			String s2=request.getParameter("s2");
			String s3=request.getParameter("s3");
			String s4=request.getParameter("s4");
			String s5=request.getParameter("s5");
			Employee e=new Employee(s1,s2,s3,s4,s5);
			db.editEmployee(e);
		}
		
	}

}
