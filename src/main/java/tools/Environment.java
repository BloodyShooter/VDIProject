package tools;

import java.util.Map;

public class Environment {

    public Map<String, String> getEnvMap() {
        return System.getenv();
    }
}
