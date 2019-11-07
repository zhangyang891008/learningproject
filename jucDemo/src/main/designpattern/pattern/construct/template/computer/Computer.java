package pattern.construct.template.computer;

public class Computer {
    private String box;
    private String cpu;
    private String memory;
    private String disk;
    private String battery;

    public Computer(){

    }

    @Override
    public String toString() {
        return "Computer{" +
                "box='" + box + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", battery='" + battery + '\'' +
                '}';
    }

    public Computer(String box, String cpu, String memory, String disk, String battery) {
        this.box = box;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.battery = battery;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
