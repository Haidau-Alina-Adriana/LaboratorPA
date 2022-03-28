package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path) throws IOException {
        return new ObjectMapper().readValue(new File(path), Catalog.class);
    }

    public static void toString(Catalog catalog) {
        System.out.println("Name: " + catalog.getName() + "\n" + "Content: ");
        for (int i = 0, n = catalog.getItems().size(); i < n; i++) {
            System.out.print("Item " + i + ": \n" + "\tid: " + catalog.getItems().get(i).getId() + "\n\ttitle: " + catalog.getItems().get(i).getTitle()
                    + "\n\tlocation: " + catalog.getItems().get(i).getLocation());
            if (catalog.getItems().get(i) instanceof Book) {
                Book b = (Book) catalog.getItems().get(i);
                System.out.println("\n\tauthor(s): " + b.getAuthors() + "\n\tcategory: " + b.getCategory() + "\n\tlanguage: " + b.getLanguage()
                        + "\n\tpublish year: " + b.getPublishYear());
            } else if (catalog.getItems().get(i) instanceof Article) {
                Article a = (Article) catalog.getItems().get(i);
                System.out.println("\n\tauthor(s): " + a.getAuthors() + "\n\tpublish year: " + a.getPublishYear());
            }
        }
    }

    public static void view(Catalog catalog, Item item) throws InvalidData, IOException {
        if (item != null) {
            File file;

            if (item.getTitle() == null) {
                throw new InvalidData("Null name!");
            }
            if (item.getLocation() == null) {
                throw new InvalidData("Item doesn't have a path!");
            }
            file = new File(item.getLocation());
            String path = item.getLocation();


            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();

            UrlValidator url = new UrlValidator();
            if (url.isValid(path)) {
                try {
                    desktop.browse(new URI(path));
                } catch (URISyntaxException e) {
                    System.out.println(e);
                }
            } else {
                try {
                    desktop.open(file);
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            }

        } else {
            throw new InvalidData("Null item!");
        }
    }

    public static void report(Catalog catalog, String htmlPath) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("catalogName", catalog.getName());
        context.put("catalogItems", catalog.getItems());

        Writer writer = new FileWriter(new File(htmlPath));
        Velocity.mergeTemplate("./src/HTMLdocument.vm", "UTF-8", context, writer);
        writer.flush();
        writer.close();

        Desktop desktop = Desktop.getDesktop();
        File htmlReport = new File(htmlPath);
        try {
            desktop.open(htmlReport);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static void getMetadata(String path) {
        File file = new File(path);
        try {
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputStream = new FileInputStream(file);
            ParseContext context = new ParseContext();

            parser.parse(inputStream, handler, metadata, context);
            String[] metadataNames = metadata.names();
            for (String name : metadataNames) {
                System.out.println(name + ": " + metadata.get(name));
            }
        } catch (TikaException | SAXException | IOException e) {
            System.out.println(e);
        }
    }

}
