import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author Nikita Liashevich on 11/23/15.
 */
public class EntryPoint {

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Configuration(), new NodeEdgesWeightJob(), args);
    }
}
