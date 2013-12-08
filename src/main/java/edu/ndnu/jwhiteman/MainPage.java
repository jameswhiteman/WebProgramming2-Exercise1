package edu.ndnu.jwhiteman;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;
import java.util.Date;
import java.io.Serializable;

@ManagedBean
@Named("mainPage")
@SessionScoped
public class MainPage implements Serializable
{
	private String welcome = null;
	private Date previousVisit = null;

	private String param = "";

	public String getTime()
	{
  		Date date = new Date();
		return date.toString();
	}

	public String getWelcome()
	{
		String lastVisit = "";
		if (welcome == null)
		{
			welcome = "Welcome friend!";
		}
		else
		{
			welcome = "Welcome back, buddy!";
			lastVisit = " Your last visit was at " + previousVisit.toString();
		}
		previousVisit = new Date();
		return welcome + lastVisit;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public String getParam()
	{
		return param;
	}
}