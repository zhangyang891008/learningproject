package pattern.construct.template.computer;


import org.junit.Test;


public class MainTest {

    @Test
    public void test() {
        ComputerTemplate template = new HighQComputerTemplate();
        Computer computer = template.produceComputer();
        System.out.println(computer);

        ComputerTemplate template1 = new LowQComputerTemplate();
        Computer computer1 = template1.produceComputer();
        System.out.println(computer1);

        ComputerTemplate template2 = new ComputerTemplate();
        Computer computer2 = template2.produceComputer();
        System.out.println(computer2);
    }

}
