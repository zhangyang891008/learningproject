package no20191214;

public class PriorityTask implements Runnable ,Comparable<PriorityTask>{
    private String taskName;
    private Integer serial;

    public PriorityTask(String name, Integer serial){
        this.taskName = name;
        this.serial = serial;
    }
    @Override
    public void run() {
        System.out.println("task running");
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(PriorityTask o) {
        return this.serial - o.serial;
    }

    @Override
    public String toString() {
        return "PriorityTask{" +
                "taskName='" + taskName + '\'' +
                ", serial=" + serial +
                '}';
    }
}
