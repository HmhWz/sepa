package com.hmh.core.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * 
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年6月30日
 * @see
 * @since webbf V1.0.0
 */
public class UrlServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrlServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        RequestDispatcher rd = request
            .getRequestDispatcher("/WEB-INF/html/" + RelativeUrl.getPageUrl("index"));

        /*
         * 这里做权限控制
         */

        // HttpSession session = request.getSession();
        // SessionInfo obj =
        // (SessionInfo)session.getAttribute(ConfigUtil.getSessionInfoName());
        String page = request.getParameter("page");
        // if (obj != null)
        // {
        // boolean result =
        // AuthManager.getInstance().checkAuthForUrlOfJsp(obj.getUserId(),
        // page);
        // if(result==false)
        // {
        // page = null;
        // }
        rd = request.getRequestDispatcher("/WEB-INF/html/" + RelativeUrl.getPageUrl(page));
        // }
        // else {
        // rd = request.getRequestDispatcher("/WEB-INF/html/"
        // + RelativeUrl.getPublicPageUrl(page));
        // }
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

}
