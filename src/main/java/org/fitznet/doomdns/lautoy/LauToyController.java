package org.fitznet.doomdns.lautoy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class LauToyController {

    @GetMapping("/LED")
    public int BlinkLED() throws InterruptedException, IOException {
        // Use processbulder to call a python script that blinks the LED
        // Return true if successful
        ProcessBuilder pb = new ProcessBuilder("python3", "blink.py");
        pb.redirectErrorStream(true);
        // Start process
        Process p = pb.start();
        // Read process output
        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        // See if python script was successful
        int exitCode = p.waitFor();

        return exitCode;
    }
}