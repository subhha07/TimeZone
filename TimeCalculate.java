package com.timecalc;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class TimeCalculate extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res){
		try
		{
			String country = req.getParameter("country");
			PrintWriter printWriter = res.getWriter();
			SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("dd MM yyyy HH:MM:ss z");
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(country));
			String time = simpleDateFormat.format(Calendar.getInstance().getTime());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
			requestDispatcher.include(req, res);
			printWriter.println(("<div>"+"<h1 class=\"time\">"+time+"</h1>"+"</div>"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
} 