/**
 *   A Program for Parsing HTML Course Notes
 */
package webwriter;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Anton Rasmussen
 */
public abstract class WebWriter extends Writer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String[] pages = {"Software Development Process Models.html", 
                          "What Makes Software Development Difficult.html",
                          "Team Organization.html",
                          "Eliciting Requirements.html",
                          "Writing Requirements.html"};
        
        try (PrintWriter out = new PrintWriter(
                               new FileWriter("outputfile.txt"))) {
            
            
            for (String page : pages) {
                
                out.println("========Page [BEGIN]: " + page + "===========");
                
                String courseNotesPage;
                courseNotesPage = page;
                
                StringBuilder notesBuilder = new StringBuilder();
                
                try {
                    try (BufferedReader in = new BufferedReader(
                            new FileReader(courseNotesPage))) {
                        String html;
                        while ((html = in.readLine()) != null) {
                            notesBuilder.append(html);
                        }
                    }
                } catch (IOException e) {
                }
                
                String notes = notesBuilder.toString();
                Document document = Jsoup.parse(notes);
                
                out.println(document.title());
                
                Elements paragraphs = document.getElementsByTag("p");
                
                paragraphs.forEach((paragraph) -> {
                    out.println(paragraph.text() + " ");
                });
                
                out.println("========Page [END]: " + page + "===========");
                
            }
        }
    }
}
