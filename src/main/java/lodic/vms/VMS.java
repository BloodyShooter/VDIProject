package lodic.vms;

import lodic.cmd.CmdClass;

import java.util.ArrayList;
import java.util.List;

public class VMS {

    private static final String COMMAND_GET_LIST_VMS = "VBoxManage list vms";

    public List<String> getListVMS() {
        CmdClass cmdClass = new CmdClass();
        List<String> respounse = cmdClass.run(COMMAND_GET_LIST_VMS);

        List<String> vms = new ArrayList<>();

        for (String line: respounse) {
            vms.add(line.split(" ")[0]);
        }

        return vms;
    }
}
