import org.apache.commons.lang3.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YouTubeTagsSpark {

    public static void main(String[] args) {

        List<Map.Entry> sortedTags = sortedTagsAnalysis();
        for (Map.Entry entry : sortedTags) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    }



    public static List<Map.Entry> sortedTagsAnalysis(){
        // CREATE SPARK CONTEXT

        SparkConf conf = new SparkConf ().setAppName ("tagsCounts").setMaster ("local[2]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("src/main/resources/USvideos.csv");
        // TRANSFORMATIONS
        JavaRDD<String> allTags = videos
                .map ((str)->{try {
                    return str.split (",")[6];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return "";
                }})
                .filter (StringUtils::isNotBlank);
        // JavaRDD<String>
        JavaRDD<String> tags = allTags.flatMap (tag -> Arrays.asList (tag
                .toLowerCase ()
                .trim ()
                .replaceAll ("\\p{Punct}", " ")
                .split (" ")).iterator ());
        // COUNTING
        Map<String, Long> wordCounts = tags.countByValue ();
        return wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
    }
}

