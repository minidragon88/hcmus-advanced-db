package hcmus.advanced_db.log_generator.model;

import hcmus.advanced_db.log_generator.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static hcmus.advanced_db.log_generator.Constants.CONFIG;

public class HostDetail
{
    private final String host;
    private List<ProcessDetail> processes = new ArrayList<>();

    public HostDetail(final String host)
    {
        this.host = host;
    }

    public static HostDetail newHostDetail()
    {
        final String host = CONFIG.getHost();
        final HostDetail hostDetail = new HostDetail(CONFIG.getHost());
        for (final String process : CONFIG.getNormalProcesses()) {
            hostDetail.addProcess(new ProcessDetail(host, process, Utility.getProcessOwner(), Utility.normalProcessValue(), Utility.normalProcessValue()));
        }
        hostDetail.addProcess(new ProcessDetail(host, CONFIG.getMaciliousProcess(), Utility.getProcessOwner(), Utility.normalProcessValue(), Utility.normalProcessValue()));
        return hostDetail;
    }

    public List<ProcessDetail> getProcesses()
    {
        return processes;
    }

    public void setProcesses(final List<ProcessDetail> processes)
    {
        this.processes = processes;
    }

    public void addProcess(final ProcessDetail process)
    {
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
    public String toString()
    {
        return String.format("host=%s, cpu=%s, mem=%s", host, getOverallCpu(), getOverallMemory());
    }

    public String toLineProtocol()
    {
        return String.format("heartbeats,host=%s cpu=%s,memory=%s", host, getOverallCpu(), getOverallMemory());
    }
}
