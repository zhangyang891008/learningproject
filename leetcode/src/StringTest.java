public class StringTest {

    public static void main(String[] args) {
        String file = "./nclogs/${server}/nc-log.log";
        String secondpart = file.substring(file.indexOf('}')+1);
        String firstpart = "./nclogs/" + "searchserver"+secondpart;
        System.out.println(firstpart);
    }
}
