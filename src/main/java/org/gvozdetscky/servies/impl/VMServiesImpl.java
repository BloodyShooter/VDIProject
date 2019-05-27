package org.gvozdetscky.servies.impl;

import org.gvozdetscky.lodic.vms.VMS;
import org.gvozdetscky.servies.VMServies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VMServiesImpl implements VMServies {

    private VMS vms = new VMS();

    public List<String> listAllVMs() {
        return vms.getListVMS(VMS.ALL);
    }

    public List<String> listRunningVMs() {
        return vms.getListVMS(VMS.RUNNING);
    }

    public int startVM(String nameVM) {
        return vms.startVM(nameVM);
    }

    public int powerOffVM(String nameVM) {
        return vms.powerOffVM(nameVM);
    }
}
