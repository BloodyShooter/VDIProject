package org.gvozdetscky.lodic.vms;

import org.gvozdetscky.cmd.CmdClass;
import org.gvozdetscky.model.VM;
import org.gvozdetscky.tools.OsUtils;

import java.util.ArrayList;
import java.util.List;

public class VMS {

    private static final String COMMAND_GET_LIST_VMS = "VBoxManage list vms";
    private static final String COMMAND_GET_RUNNING_LIST_VMS = "VBoxManage list runningvms";

    /**
     * Режим получения всех виртуальных машин из списка
     */
    public static final int ALL = 0;
    /**
     * Режим получения работающих виртуальных машин из списка
     */
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

    /**
     * Метод для запуска виртуальной машины
     * @param name имя ВМ которую запускаем
     * @return возврашает статус
     * 1 - Все хорошо
     * 2,3 ошибка
     */
    public int startVM(String name) {
        CmdClass cmdClass = new CmdClass();

        String command = "VBoxManage startvm \"" + name + "\" --type headless";

        List<String> respounse = cmdClass.run(command);

        for (String line: respounse) {
            System.out.println(line);
        }

        if (respounse.size() == 0) return 3;

        if (respounse.get(respounse.size() - 1).contains("has been successfully started.")) return 1;

        return 2;
    }

    /**
     * Метод отключает питание на виртуальной машине
     * @param name виртуальная машина которою отрубаем
     * @return 1 в случае успеха(пока еще ничего другого не придумал)
     */
    public int powerOffVM(String name) {
        CmdClass cmdClass = new CmdClass();

        String command = "vboxmanage controlvm \"" + name + "\" poweroff";

        List<String> respounse = cmdClass.run(command);

        for (String line: respounse) {
            System.out.println(line);
        }

        return 1;
    }

    /**
     * Запускаем подключение к машине через rdp протокол
     * @param vm Виртуальная машина, откуда будет браться ip и port
     */
    public void connectVM(VM vm) {

        CmdClass cmdClass = new CmdClass();

        String command = "mstsc.exe /v:192.168.91.143 /f";

        if (OsUtils.isWindows()) {
            cmdClass.run(command);
        }
    }

}
