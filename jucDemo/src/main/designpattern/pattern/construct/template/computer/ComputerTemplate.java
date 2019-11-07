package pattern.construct.template.computer;

public class ComputerTemplate {

    private Computer computer = new Computer();

    public final Computer produceComputer(){
        try{
            computer.setBox(getBox());
            computer.setCpu(getCpu());
            computer.setMemory(getMemory());
            computer.setDisk(getDisk());
            computer.setBattery(getBattery());

        } catch (Exception e){
            System.out.println("producing computer error!"+e);
            return null;
        }

        return computer;
    }

    public String getBox(){
        throw new RuntimeException("box is not found");
    }

    public String getCpu(){
        throw new RuntimeException("cpu is not found");
    }

    public String getMemory(){
        throw new RuntimeException("memory is not found");
    }

    public String getDisk(){
        throw new RuntimeException("disk is not found");
    }

    public String getBattery(){
        throw new RuntimeException("battery is not found");
    }

}
