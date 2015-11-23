import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Nikita Liashevich on 11/23/15.
 */
public class NodeEdgesWeightMapper extends Mapper<LongWritable, Text, LongWritable, LongWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] values = line.split("\t");

        Long nodeId = Long.parseLong(values[1]);
        Long weight = Long.parseLong(values[2]);

        context.write(new LongWritable(nodeId), new LongWritable(weight));
    }
}
