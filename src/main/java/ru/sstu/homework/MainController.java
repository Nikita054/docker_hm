package ru.sstu.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

@RestController
public class MainController {

    @GetMapping("/serv/{text}")
    public void getCourseByGenre(@PathVariable("text") String text) throws IOException {
        BufferedWriter out = null;

        try {
            FileWriter fstream = new FileWriter("/logs/logs.txt", true); //true tells to append data.
            out = new BufferedWriter(fstream);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String message = timestamp + " - " + text + "\n";
            System.out.println("Get new request with timestamp: " + timestamp);
            out.write(message);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
