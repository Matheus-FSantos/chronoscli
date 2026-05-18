package io.github.matheus_fsantos.engine;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;

public class CpuCore {
    private HardwareAbstractionLayer hardware;

    public CpuCore() {
        SystemInfo si = new SystemInfo();
        this.hardware = si.getHardware();
    }

    public String getCpuName() {
        return this.hardware.getProcessor().getProcessorIdentifier().getName();
    }

    public float getCpuUsage() {
        CentralProcessor cpu = this.hardware.getProcessor();
        long[] ticks = cpu.getSystemCpuLoadTicks();
        Util.sleep(1000);
        double globalUsage = cpu.getSystemCpuLoadBetweenTicks(ticks) * 100;
        return Math.round(globalUsage);
    }
}
