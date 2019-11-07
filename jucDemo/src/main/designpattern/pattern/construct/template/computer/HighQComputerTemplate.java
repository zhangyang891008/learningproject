package pattern.construct.template.computer;

public class HighQComputerTemplate extends ComputerTemplate{

    @Override
    public String getBox() {
        return "HighQ-Box";
    }

    @Override
    public String getCpu() {
        return "HighQ-Cpu";
    }

    @Override
    public String getMemory() {
        return "HighQ-Memory";
    }

    @Override
    public String getDisk() {
        return "HighQ-disk";
    }

    @Override
    public String getBattery() {
        return "HighQ-Battery";
    }
}
