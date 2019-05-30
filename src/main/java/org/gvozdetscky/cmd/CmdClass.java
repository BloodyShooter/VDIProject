package org.gvozdetscky.cmd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CmdClass {
    public List<String> run(String command) {

        List<String> respuonce = new ArrayList<>();

        try {

            Process proc = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                respuonce.add(line);
            }
            proc.waitFor();
            proc.destroy();


        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return respuonce;
    }

    public Map<String, String> getEnvMap() {
        return System.getenv();
    }
}
