package com.auki.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service=Servlet.class,
	property= {
			Constants.SERVICE_DESCRIPTION + "=Servlet demo",
            "sling.servlet.methods=" + HttpConstants.METHOD_GET + HttpConstants.METHOD_POST ,
            "sling.servlet.paths=" + "/bin/test",
            "sling.servlet.extensions=" + "json"
	}
		)
public class TestServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
		JSONObject obj=new JSONObject();
		try {
			obj.put("test","testValue");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		if(req.getParameter("q").equalsIgnoreCase("testing")) {

			resp.getWriter().write(obj.toString());
		}

	}
	
	protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String dec = req.getParameter("dec");
		String date = req.getParameter("date");
		String imgUrl = req.getParameter("img");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		JSONObject obj=new JSONObject();
		try {
			obj.put("title", title);
			obj.put("dec", dec);
			obj.put("date", date);
			obj.put("imgUrl", imgUrl);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(obj.toString());

		  	  

	}
}
