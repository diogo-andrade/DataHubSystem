package fr.gael.dhus.server.http;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
@WebApp (
        name = "rasdaman"
)
public class PetascopeWebapp extends WebApplication implements InitializingBean {

    @Override
    public void configure(String destFolder) throws IOException {
        String configurationFolder = "fr/gael/dhus/server/http/rasdaman/webapp";
        URL u = Thread.currentThread ().getContextClassLoader ().getResource (configurationFolder);
        if (u != null && "jar".equals (u.getProtocol ()))
        {
            extractJarFolder(u, configurationFolder, destFolder);
        }
        else if (u != null)
        {
            File webAppFolder = new File(destFolder);
            copyFolder(new File(u.getFile ()), webAppFolder);
        }
    }

    @Override
    public boolean hasWarStream() {
        return false;
    }

    @Override
    public InputStream getWarStream() {
        return SolrWebapp.class.getClassLoader ().getResourceAsStream ("rasdaman.war");
    }

    @Override
    public void checkInstallation() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
