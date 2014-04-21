package org.edu.sjsu.icd.fdmr;

import java.io.IOException;
import java.sql.Date;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author Deepti
 *
 */
public class FDReducer extends Reducer<Text, IntWritable, OutputWritable, NullWritable> {
	protected void reduce(Text key, Iterable<IntWritable> values, Context ctx) {
		try {
			String k[] = (key.toString()).split("\t");
			ctx.write(new OutputWritable(Integer.parseInt(k[0]), k[1], k[2], k[4], k[5], new Date(Long.parseLong(k[3]))), NullWritable.get());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}