import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCart extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        String str;
        String products[] = {"Nike Shoes", "Wrist watch", "School Bag", "Goggles","Trouser","Shirt"};
        double price []={5000.00,2000.00,800.00,1000.00,1500.00,500.00};
        double cost;
        double total=0.0;
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        HttpSession session = req.getSession(true);

        for (String good : products) {
            if (session.getAttribute(good) == null) {
                session.setAttribute(good, 0);
            }
        }
    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session max limit 15 sec</title>");            
            out.println("</head>");
           
            out.println("<h1>MY SHOPPING LIST </h1>");
           

    if ((str = req.getParameter("Nike Shoes")) != null)
    {
        int n = ((Integer) session.getAttribute(products[0]));
        session.setAttribute(products[0], n + 1);
    } 
    else if ((str = req.getParameter("Wrist watch")) != null) 
        {
        int n = ((Integer) session.getAttribute(products[1]));
        session.setAttribute(products[1], n + 1);
        } 
    else if ((str = req.getParameter("School Bag")) != null)
            {
               int n = ((Integer) session.getAttribute(products[2]));
               session.setAttribute(products[2], n + 1);
            }
    else if ((str = req.getParameter("Goggles")) != null)
                {
                    int n = ((Integer) session.getAttribute(products[3]));
                    session.setAttribute(products[3], n + 1);
                 } 
    else if ((str = req.getParameter("Trouser")) != null)
                        {
                            int n = ((Integer) session.getAttribute(products[4]));
                            session.setAttribute(products[4], n + 1);
                        } 
    else //if ((s = req.getParameter("Shirt")) != null)
                            {
                                int n = ((Integer) session.getAttribute(products[5]));
                                session.setAttribute(products[5], n + 1);
                            } 
        
        for (int i = 0; i < products.length; i++) 
       {
           cost=0.0;
            int n = ((Integer)session.getAttribute(products[i]));
            if ( n > 0 )
            {
                out.println("<ul><b><p> Item name :" + products[i] + "</p><p> </b> Item Qty :" + n +"<p><p> ItemPrice :"+ price[i] +"</p></ul>");
                cost=n*price[i];
                out.println("Total Cost of item :"+cost);
            }
            total+=cost;
        }
       out.println("<p><b><i>Total Amount to pay:"+total+"</i></b></p>");
       out.println("<form action=\"BillGenerator\" method=\"post\"><input type='hidden' value="+total+" name='totalBill'><button type=\"submit\" >Pay Now</button></form>");
       
       // out.println("</body>");
        out.println("</html>");
        RequestDispatcher rd=req.getRequestDispatcher("/index.html");  
        rd.include(req, res);
        session.setMaxInactiveInterval(15);
    }
   
}