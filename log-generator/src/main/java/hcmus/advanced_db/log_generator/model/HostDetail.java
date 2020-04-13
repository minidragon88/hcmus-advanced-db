package hcmus.advanced_db.log_generator.model;

import static hcmus.advanced_db.log_generator.Constants.CONFIG;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hcmus.advanced_db.log_generator.Utility;

public class HostDetail{
    private final String host;
    private List<ProcessDetail> processes = new ArrayList<>();
    public HostDetail(final String host) {
        this.host = host;
    }
    
    public List<ProcessDetail> getProcesses() {
        return processes;
    }
    
    public void setProcesses(final List<ProcessDetail> processes) {
        this.processes = processes;
    }
    
    public void addProcess(final ProcessDetail process) {
        processes.add(process);
    }
    
    public double getOverallCpu()
    {
        return processes.stream().map(process -> process.getCpu()).collect(Collectors.summingDouble(Double::doubleValue));
    }
    
    public double getOverallMemory()
    {
        return processes.stream().map(process -> process.getMem()).collect(Collectors.summingDouble(Double::doubleValue));
    }
    
    @Override
    public String toString() {
        return String.format("host=%s, cpu=%s, mem=%s", host, getOverallCpu(), getOverallMemory());
    }
    
    public static HostDetail newHostDetail()
    {
        final String host = CONFIG.getHost();
        final HostDetail hostDetail = new HostDetail(CONFIG.getHost());
        for (final String process : CONFIG.getNormal_processes()) {
            hostDetail.addProcess(new ProcessDetail(host, process, Utility.getProcessOwner(), Utility.normalProcessValue(), Utility.normalProcessValue()));
        }
        hostDetail.addProcess(new ProcessDetail(host, CONFIG.getMacilious_process(), Utility.getProcessOwner(), Utility.normalProcessValue(), Utility.normalProcessValue()));
        return hostDetail;
    }
}
