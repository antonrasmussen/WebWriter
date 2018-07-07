/*
 * The MIT License
 *
 * Copyright 2018 Anton Rasmussen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */ 

/**
 *   A Program for Parsing HTML Course Notes
 */
package webwriter;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
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
