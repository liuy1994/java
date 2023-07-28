package com.company;
import java.io.*;
import java.net.URL;
import java.nio.charset.*;

public class News {
    private String title;
    private String content;

    public void read(String fileUrl) throws IOException {
        FileInputStream input = new FileInputStream(fileUrl);
        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);

        this.title = buffer.readLine();
        this.content = buffer.readLine();

        buffer.close();
        reader.close();
        input.close();
    }

    private void readFromHttp(String httpUrl) throws IOException {
        InputStream input = new URL(httpUrl).openStream();
        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        this.title = "google";
        this.content = String.valueOf(buffer.read());
    }

    public void write(String fileUrl) throws IOException {
        FileOutputStream output = new FileOutputStream(fileUrl);
        OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
        PrintWriter print = new PrintWriter(writer);
        print.print(this.display());
        print.close();
        writer.close();
        output.close();
    }

     public String display() {
        return "title: " + title + "\ncontent: " + content;
    }

}
