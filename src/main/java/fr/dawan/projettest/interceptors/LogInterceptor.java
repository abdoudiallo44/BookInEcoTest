package fr.dawan.projettest.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{

	//intercepte les requêtes avant qu'elles arrivent dans les contrôleurs
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().contains("/livres")) {
			if(request.getSession().getAttribute("login") == null) {
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}
		return true;
		//return super.preHandle(request, response, handler);
	}
	
	
	

}
