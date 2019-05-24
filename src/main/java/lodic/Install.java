package lodic;

import java.io.*;

public class Install {
    public String run(String command) {

        String respuonce = "";

        try {
            Process proc = Runtime.getRuntime().exec(command);
            proc.waitFor();
            proc.destroy();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                respuonce += line + "/n";
            }

            System.out.println();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuonce;
    }
}
