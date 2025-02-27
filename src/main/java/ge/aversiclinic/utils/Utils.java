package ge.aversiclinic.utils;

public class Utils {
    //ლოგავს შეტყობინებას კონკრეტულად ყველა ტესტ ქეისზე
    public static void log(String text){

        if (ReportManager.getTest() != null){
            ReportManager.getTest().info(text);
        }
    }

}
