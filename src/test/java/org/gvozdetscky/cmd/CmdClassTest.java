package org.gvozdetscky.cmd;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CmdClassTest {
    @Test
    public void testInstall() {
        CmdClass i = new CmdClass();

        List<String> respounse = i.run("VBoxManage list vms");

        for (String line: respounse) {
            System.out.println(line);
        }
    }

    @Test
    public void getEnvMap() {
        CmdClass cmdClass = new CmdClass();
        Map<String, String> envMap = cmdClass.getEnvMap();

        for (String envName: envMap.keySet()) {
            System.out.println(envName + envMap.get(envName));
        }
    }
}