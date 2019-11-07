package pattern.construct.template.computer;

public class LowQComputerTemplate extends ComputerTemplate{

    @Override
    public String getBox() {
        return "LowQ-Box";
    }

    @Override
    public String getCpu() {
        return "LowQ-Cpu";
    }

    @Override
    public String getMemory() {
        return "LowQ-Memory";
    }

    @Override
    public String getDisk() {
        return "LowQ-disk";
    }

    @Override
    public String getBattery() {
        return "LowQ-Battery";
    }
}
