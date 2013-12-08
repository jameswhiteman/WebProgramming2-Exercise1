package edu.ndnu.jwhiteman;

import java.util.Enumeration;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class MainServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private ArrayList<String> values;
    private ArrayList<String> names;

    public void init() throws ServletException
    {
        // Initialize the keys and values of the init params.
        Enumeration<String> keys = getServletConfig().getInitParameterNames();
        values = new ArrayList<String>();
        names = new ArrayList<String>();

        // Get the init parameter keys.
        while (keys.hasMoreElements())
        {
            String key = keys.nextElement();
            String value = getServletConfig().getInitParameter(key);
            names.add(key);
            values.add(value);
        }

        // Get the bean.
        // HttpSession session = request.
        // MainPage bean = (MainPage)session.getAttribute("mainPage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws IOException, ServletException
    {
        // Get the session.
        HttpSession session = request.getSession();

        // Change the bean's param.
        MainPage bean = (MainPage)session.getAttribute("mainPage");
        if (bean == null)
            bean = new MainPage();
        bean.setParam(getValue("findme"));
        session.setAttribute("mainPage", bean);
        
        // Forward the request.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsf");
        dispatcher.forward(request, response);
    }

    public String getValue(String key)
    {
        for (int i = 0; i < names.size(); i++)
        {
            if (names.get(i).equals(key))
            {
                return values.get(i);
            }
        }
        return "";
    }
}