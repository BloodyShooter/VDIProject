package org.gvozdetscky.vms.logic;

import org.gvozdetscky.vms.ConstVM;
import org.gvozdetscky.vms.PathIsoClass;

public class CommandVB {

    public String registrVM(String nameVM, String typeVM) {

        return "VBoxManage createvm --name " + nameVM + " --ostype " + typeVM + " --register";
    }

    public String createHDD(String nameHDD) {
        return "vboxmanage createhd " +
                "--filename C:\\vb\\vb\\test\\" + nameHDD + ".vdi " +
                "--size 35000";
    }

    public String createHDD(String nameHDD, String pathHDD, String size) {
        return "vboxmanage createhd " +
                "--filename " + pathHDD + nameHDD + ".vdi " +
                "--size " + size;
    }

    public String createSataController(String nameVM) {
        return "vboxmanage storagectl " + nameVM + " --name SATA --add sata";
    }

    public String createIdeController(String nameVM) {
        return "vboxmanage storagectl " + nameVM + " --name ide --add ide";
    }

    public String modifyMemoryAndPortAndVRam(String nameVM, String sizeMemory, String hostPort) {
        return "VBoxManage modifyvm " + nameVM + " --memory " + sizeMemory +
                " --natpf1 \"rdp,tcp,," + hostPort + ",,22\" --vram 128";
    }

    public String takeHDD(String nameVM, String nameHDD) {

        return "vboxmanage storageattach " + nameVM + " --storagectl SATA --port 0 --device 0 " +
                "--type hdd --medium C:\\vb\\vb\\test\\" + nameHDD;
    }

    public String takeDVD(String nameVM, String typeOsVM) {

        PathIsoClass pathIsoClass = new PathIsoClass();

        String osiDVD;

        switch (typeOsVM) {
            case ConstVM.WINDOWS_10_OS_TYPE:
                osiDVD = pathIsoClass.getWin10Iso();
                break;
            case ConstVM.WINDOWS_81_OS_TYPE:
                osiDVD = pathIsoClass.getWin81Iso();
                break;
            case ConstVM.WINDOWS_7_OS_TYPE:
                osiDVD = pathIsoClass.getWin81Iso();
                break;
            case ConstVM.UBUNTU_18_OS_TYPE:
                osiDVD = pathIsoClass.getWin81Iso();
                break;
            default:
                System.out.println("Неправильный тип ОС");
                return "";
        }

        return "vboxmanage storageattach " + nameVM + " --storagectl ide --port 0 " +
                "--device 1 --type dvddrive --medium " + osiDVD;
    }
}
