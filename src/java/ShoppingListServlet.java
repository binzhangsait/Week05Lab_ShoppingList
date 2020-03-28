
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 */
public class ShoppingListServlet extends HttpServlet {

    private int counter;
//    ArrayList<String> list;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do GET");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            System.out.println("=========logout");
            session.invalidate();
            response.sendRedirect("ShoppingList");
        } else {
            String userName = (String) session.getAttribute("username");
            if (userName != null && !userName.equals("")) {
                request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post");
        request.setCharacterEncoding("utf-8");//-----------> utf-8
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

        if (action != null && !action.equals("")) {
            System.out.println("action=: " + action);
            if (action.equals("register")) {
                String fldUsername = request.getParameter("fldUsername");
                if (fldUsername != null && !fldUsername.equals("")) {
                    session.setAttribute("username", fldUsername);
                }
                System.out.println("---> to shoppinglist");
                System.out.println("username: " + fldUsername);
                request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else if (action.equals("add")) {
                String fldItem = request.getParameter("fldItem");
                if (fldItem != null && !fldItem.equals("")) {

                    if (items == null) {//for safety.
                        items = new ArrayList<>();
                        items.add(fldItem);
                        session.setAttribute("items", items);
                    } else {
                        items.add(fldItem);
                        session.setAttribute("items", items);
                    }
                    System.out.println("in add---");
                } else {
                    System.out.println("no input");
                }
                System.out.println(items);

            } else if (action.equals("delete")) {
                String radSelect = request.getParameter("radSelect");
                if (radSelect != null && !radSelect.equals("")) {
                    try {
                        int selected = Integer.parseInt(radSelect);
                        items = (ArrayList<String>) session.getAttribute("items");
                        if (items == null) // For safety.
                        {
                            items = new ArrayList<String>();
                        }

                        items.remove(selected);
                        session.setAttribute("items", items);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("in delete---");
            }

        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
