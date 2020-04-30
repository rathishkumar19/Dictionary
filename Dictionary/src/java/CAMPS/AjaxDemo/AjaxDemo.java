
package CAMPS.AjaxDemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CAMPS.Connect.DBConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AjaxDemo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBConnect db = new DBConnect();
        String data ="";
        String a = request.getParameter("text1");
        try (PrintWriter out = response.getWriter()) {
            out.print(a);
            if(request.getParameter("option")== null){
                out.print("Please Specify any option and no option is specified");
            }
            else if(request.getParameter("option").equalsIgnoreCase("display")){
            db.getConnection();
            db.read("select meaning from english_dictionary where word ='"+a+"' ");
            data += "<table>";
            while (db.rs.next())
            {
                data += "<tr>";
                data += "<td>"+db.rs.getString("meaning")+"</td>";
                data +="<tr>";
            }
            data += "</table>";
            out.print(data);
            db.closeConnection();
            }
            else
                out.print("Option Undefined");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(AjaxDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
