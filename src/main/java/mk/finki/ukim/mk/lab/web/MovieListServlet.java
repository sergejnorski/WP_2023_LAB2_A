package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns  = "")
public class MovieListServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;

    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
        WebContext context =  new WebContext(webExchange);

        List<Movie> movies = movieService.listAll();
        context.setVariable("movies",movies);

        springTemplateEngine.process("listMovies.html", context, response.getWriter());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("selectedMovie");
        int numOfTickets = Integer.parseInt(request.getParameter("numTickets"));
        String name = request.getParameter("clientName");
        System.out.println(title + " " + numOfTickets + " " + name);

        response.sendRedirect("/ticketOrder?title=" + title +"&tickets=" + numOfTickets +"&name=" + name);
    }
}
