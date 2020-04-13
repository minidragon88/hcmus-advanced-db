package hcmus.advanced_db.log_generator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HostDetail{
    private final String host;
    private final List<ProcessDetail> processes = new ArrayList<>();
    public HostDetail(final String host) {
        this.host = host;
    }
    
    public List<ProcessDetail> getProcesses() {
        return processes;
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
}
