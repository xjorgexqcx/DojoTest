package pe.com.dojoLearning.portal;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HolaMundoPortlet extends GenericPortlet {
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html");
		response.getWriter().write("¡Hola Mundo Cruel de los Portlets 2.0!");
	}
}
