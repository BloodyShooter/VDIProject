package org.gvozdetscky.vms;

public class PathIsoClass {
    private static final String PATH_FOT_ISO = "C:\\vb\\os\\";
    private static final String PATH_WINDOWS_10 = "Windows10.iso";
    private static final String PATH_WINDOWS_8_1 = "Windows10.iso";
    private static final String PATH_WINDOWS_7 = "Win_Pro_7_SP1_x64_Ru.iso";
    private static final String PATH_UBUNTU_18 = "ubuntu-18.04.2-desktop-amd64.iso";

    public String getWin10Iso() {
        return PATH_FOT_ISO + PATH_WINDOWS_10;
    }

    public String getWin81Iso() {
        return PATH_FOT_ISO + PATH_WINDOWS_8_1;
    }

    public String getUbuntuIso() {
        return PATH_FOT_ISO + PATH_UBUNTU_18;
    }

    public String getWin7Iso() {
        return PATH_FOT_ISO + PATH_WINDOWS_7;
    }
}
