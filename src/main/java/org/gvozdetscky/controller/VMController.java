package org.gvozdetscky.controller;

import org.gvozdetscky.lodic.vms.VMS;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VMController {

    @RequestMapping("/getListVM")
    public String getListVM() {
        VMS vms = new VMS();
        List<String> listVMS = vms.getListVMS(VMS.ALL);

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        return response;
    }

    @RequestMapping("/getListRunningVM")
    public String getListRunningVM() {
        VMS vms = new VMS();
        List<String> listVMS = vms.getListVMS(VMS.RUNNING);

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        return response;
    }

    @RequestMapping("/run")
    public String runVM() {
        VMS vms = new VMS();
        int status = vms.startVM("xubuntu");

        if (status == 1) {
            return "Запустили";
        } else {
            return "нет";
        }
    }
}
