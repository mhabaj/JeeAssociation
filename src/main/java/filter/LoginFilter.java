package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;


/**
 * Servlet Filter implementation class LoginFilter. Classe de filtre de connexion de l'utilisateur.
 * @author sean anica, juliette rondeau, mahmodd alhabaj.
 */
@WebFilter(urlPatterns = { "/Comments.xhtml", "/Welcome.xhtml" })
public class LoginFilter implements Filter {

	/**
	 * Default constructor of the class.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * méthode qui permet de filtrer les connexions et les sessions actives.
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LoginBean bean = (LoginBean) req.getSession().getAttribute("loginBean");
		if (bean == null)
			res.sendRedirect("Login.xhtml");
		if (bean != null) {

			if (bean.getUser().getPseudo() == null) {
				res.sendRedirect("Login.xhtml");
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
