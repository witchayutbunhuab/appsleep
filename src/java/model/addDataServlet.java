package model;



import controller.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addData")
public class addDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Create an instance of DBConnection to use its methods
    private DBConnection dbConnection = new DBConnection();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("Name");
        String afterDay = request.getParameter("afterday");
        String beforeDay = request.getParameter("beforday");
        String sleepTime = request.getParameter("sleepTime");
        String wakeTime = request.getParameter("wakeTime");
        int userId = Integer.parseInt(request.getParameter("user_id"));
        
        // Create a SleepRecord object
        SleepRecord sleepRecord = new SleepRecord(name, afterDay, sleepTime, beforeDay, wakeTime, userId);
        
        // Call DBConnection method to insert data
        boolean success = dbConnection.insertSleepData(sleepRecord);
        
        // Set response content type
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Provide feedback based on insertion result
        if (success) {
            out.println("<html><body>");
            out.println("<h1>Data has been saved successfully!</h1>");
            out.println("<html><body>ชื่อ: " + name 
    + "<br/>วันหลับ:  " + afterDay
    + "<br/>วันนอน: " + beforeDay 
    + "<br/>เวลานอน: " + sleepTime 
    + "<br/>เวลาตื่น: " + wakeTime 
    + "</body></html>");
            out.println("<a href='index.html'>Go back</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>There was an error saving the data.</h1>");
            out.println("<a href='index.html'>Go back</a>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("GET method is not supported for this endpoint.");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for adding sleep data to the database.";
    }
}
