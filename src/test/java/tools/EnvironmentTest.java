package tools;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class EnvironmentTest {

    @Test
    public void getEnvMap() {
        Environment env = new Environment();
        Map<String, String> envMap = env.getEnvMap();

        for (String envName: envMap.keySet()) {
            System.out.println(envName + envMap.get(envName));
        }
    }
}