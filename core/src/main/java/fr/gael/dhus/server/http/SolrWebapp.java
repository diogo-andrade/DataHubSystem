/*
 * Data Hub Service (DHuS) - For Space data distribution.
 * Copyright (C) 2013,2014,2015 GAEL Systems
 *
 * This file is part of DHuS software sources.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.gael.dhus.server.http;

import fr.gael.dhus.database.object.config.search.SolrConfiguration;
import fr.gael.dhus.system.config.ConfigurationManager;
import fr.gael.dhus.system.init.SolrInitializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebApp(
      name = "solr",
      allowIps = "127.\\d+.\\d+.\\d+|::1|0:0:0:0:0:0:0:1")
public class SolrWebapp extends WebApplication implements InitializingBean
{
   private static final Logger LOGGER = Logger.getLogger(SolrWebapp.class);

   @Autowired
   private ConfigurationManager configurationManager;

   @Autowired
   private SolrInitializer solrInitializer;

   @Override
   public void configure(String dest_folder) throws IOException
   {
      String configurationFolder = "fr/gael/dhus/server/http/solr/webapp";
      URL u = Thread.currentThread().getContextClassLoader()
            .getResource(configurationFolder);
      if (u != null && "jar".equals(u.getProtocol()))
      {
         extractJarFolder(u, configurationFolder, dest_folder);
      }
      else if (u != null)
      {
         File webAppFolder = new File(dest_folder);
         copyFolder(new File(u.getFile()), webAppFolder);
      }
   }

   @Override
   public InputStream getWarStream()
   {
      return SolrWebapp.class.getClassLoader().getResourceAsStream(
            "solr.war");
   }

   @Override
   public boolean hasWarStream()
   {
      return true;
   }

   @Override
   public void afterPropertiesSet() throws Exception
   {
      try
      {
         SolrConfiguration solr = configurationManager.getSolrConfiguration();

         File solrroot = new File(solr.getPath());
         System.setProperty("solr.solr.home", solrroot.getAbsolutePath());

         File libdir = new File(solrroot, "lib");
         libdir.mkdirs();
         File coredir = new File(solrroot, "dhus");
         coredir.mkdirs();
         File confdir = new File(coredir, "conf");

         // Move old data/conf dirs if any
         File olddata = new File(solrroot, "data/dhus");
         if (olddata.exists())
         {
            File newdata = new File(coredir, "data");
            olddata.renameTo(newdata);
         }
         File oldconf = new File(solrroot, "conf");
         if (oldconf.exists())
         {
            oldconf.renameTo(confdir);
         }
         confdir.mkdirs();
         // Rename old `schema.xml` file to `managed-schema`
         File schemafile = new File(confdir, "managed-schema");
         File oldschema  = new File(confdir, "schema.xml");
         if (oldschema.exists())
         {
            oldschema.renameTo(schemafile);
         }

         // solr.xml
         InputStream input = ClassLoader.getSystemResourceAsStream(
               "fr/gael/dhus/server/http/solr/solr.xml");
         OutputStream output = new FileOutputStream(
               new File(solrroot, "solr.xml"));
         IOUtils.copy(input, output);
         output.close();
         input.close();

         // dhus/core.properties
         input = ClassLoader
               .getSystemResourceAsStream("fr/gael/dhus/server/http/solr/core.properties");
         File core_props = new File(coredir, "core.properties");
         output = new FileOutputStream(core_props);
         IOUtils.copy(input, output);
         output.close();
         input.close();

         // dhus/solrconfig.xml
         input = ClassLoader.getSystemResourceAsStream(
               "fr/gael/dhus/server/http/solr/solrconfig.xml");
         File solrconfigfile = new File(confdir, "solrconfig.xml");
         output = new FileOutputStream(solrconfigfile);
         IOUtils.copy(input, output);
         output.close();
         input.close();

         // dhus/schema.xml
         if (!schemafile.exists())
         {
            String schemapath = solr.getSchemaPath();
            if ((schemapath == null)
                  || ("".equals(schemapath))
                  || (!(new File(schemapath)).exists()))
            {
               input = ClassLoader.getSystemResourceAsStream(
                     "fr/gael/dhus/server/http/solr/schema.xml");
            }
            else
            {
               input = new FileInputStream(new File(schemapath));
            }
            output = new FileOutputStream(schemafile);
            IOUtils.copy(input, output);
            output.close();
            input.close();
         }

         // dhus/stopwords.txt
         input = ClassLoader.getSystemResourceAsStream(
               "fr/gael/dhus/server/http/solr/stopwords.txt");
         output = new FileOutputStream(new File(confdir, "stopwords.txt"));
         IOUtils.copy(input, output);
         output.close();
         input.close();

         // dhus/synonyms.txt
         String synonympath = solr.getSynonymPath();
         if ((synonympath == null)
               || ("".equals(synonympath))
               || (!(new File(synonympath)).exists()))
         {
            input = ClassLoader.getSystemResourceAsStream(
                  "fr/gael/dhus/server/http/solr/synonyms.txt");
         }
         else
         {
            input = new FileInputStream(new File(synonympath));
         }
         output = new FileOutputStream(new File(confdir, "synonyms.txt"));
         IOUtils.copy(input, output);
         output.close();
         input.close();

         // dhus/xslt/opensearch_atom.xsl
         input = ClassLoader.getSystemResourceAsStream(
               "fr/gael/dhus/server/http/solr/xslt/opensearch_atom.xsl");
         if (input != null)
         {
            File xslt_dir = new File(confdir, "xslt");
            if (!xslt_dir.exists())
            {
               xslt_dir.mkdirs();
            }
            output = new FileOutputStream(
                  new File(xslt_dir, "opensearch_atom.xsl"));
            IOUtils.copy(input, output);
            output.close();
            input.close();
         }
         else
         {
            LOGGER.warn("Cannot file opensearch xslt file. "
                  + "Opensearch interface is not available.");
         }

         solrInitializer.createSchema(coredir.getAbsolutePath(),
               schemafile.getAbsolutePath());

      }
      catch (IOException e)
      {
         throw new UnsupportedOperationException(
               "Cannot initialize Solr service.", e);
      }
   }

   @Override
   public void checkInstallation() throws Exception {}
}
