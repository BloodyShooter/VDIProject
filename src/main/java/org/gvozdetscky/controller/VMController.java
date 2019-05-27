package org.gvozdetscky.controller;

import org.gvozdetscky.servies.VMServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VMController {

    @Autowired
    private VMServies vmServies;

    @RequestMapping("/api/getListVM")
    public String getListVM() {
        List<String> listVMS = vmServies.listAllVMs();

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        return response;
    }

    @RequestMapping("/api/getListRunningVM")
    public String getListRunningVM() {
        List<String> listVMS = vmServies.listRunningVMs();

        String response = "";

        for (String nameVM: listVMS) {
            response += nameVM + "\n";
        }

        System.out.println(response);

        return response;
    }

    @RequestMapping("/api/run")
    public String runVM() {
        int status = vmServies.startVM("xubuntu");

        if (status == 1) {
            return "Запустили";
        } else {
            return "нет";
        }
    }

    @RequestMapping("/api/powerOff")
    public String powerOffVM() {
        int status = vmServies.powerOffVM("xubuntu");

        if (status == 1) {
            return "Вюключили";
        } else {
            return "Нет";
        }
    }
}
