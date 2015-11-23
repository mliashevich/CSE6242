import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Nikita Liashevich on 11/23/15.
 */
public class NodeEdgesWeightReducer extends Reducer<LongWritable, LongWritable, LongWritable, LongWritable> {

    @Override
    protected void reduce(LongWritable key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long totalWeight = 0;

        for(LongWritable weight : values) {
            totalWeight += weight.get();
        }

        context.write(key, new LongWritable(totalWeight));
    }
}
