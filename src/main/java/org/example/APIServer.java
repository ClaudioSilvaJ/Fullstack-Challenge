package org.example;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.configs.MorphiaConfig;
import org.example.configs.CorsFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.mongodb.morphia.Datastore;
public class APIServer {
    static Integer mongoDBPort = 27017;
    protected static Datastore datastore = new MorphiaConfig("FSCDatabase", mongoDBPort).getDatastore();

    public static void main(String[] args) throws Exception {
        Server server = new Server(8231);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/api/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "org.example");
        context.addFilter(CorsFilter.class, "/*", null);
        server.start();
        server.join();
    }

    public static void setDatastore(Datastore datastore) {
        APIServer.datastore = datastore;
    }
}
