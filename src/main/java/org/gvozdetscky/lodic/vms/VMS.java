package org.gvozdetscky.lodic.vms;

import org.gvozdetscky.cmd.CmdClass;

import java.util.ArrayList;
import java.util.List;

public class VMS {

    private static final String COMMAND_GET_LIST_VMS = "VBoxManage list vms";
    private static final String COMMAND_GET_RUNNING_LIST_VMS = "VBoxManage list runningvms";

    public static final int ALL = 0;
    public static final int RUNNING = 1;

    public List<String> getListVMS(int mode) {
        CmdClass cmdClass = new CmdClass();
        List<String> respounse = null;
        if (mode == ALL)
            respounse = cmdClass.run(COMMAND_GET_LIST_VMS);
        else if (mode == RUNNING) {
            respounse = cmdClass.run(COMMAND_GET_RUNNING_LIST_VMS);
        }

        if (respounse == null) return null;

        List<String> vms = new ArrayList<>();

        for (String line: respounse) {
            vms.add(line.split("\"")[1]);
        }

        return vms;
    }

    public int startVM(String nameVM) {
        CmdClass cmdClass = new CmdClass();

        String command = "VBoxManage startvm " + nameVM + " --type headless";

        List<String> respounse = cmdClass.run(command);

        for (String line: respounse) {
            System.out.println(line);
        }

        if (respounse.size() == 0) return 3;

        if (respounse.get(respounse.size() - 1).contains("has been successfully started.")) return 1;

        return 2;
    }


}
