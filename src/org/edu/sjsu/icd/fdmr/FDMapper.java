package org.edu.sjsu.icd.fdmr;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

@SuppressWarnings("javadoc")
public class FDMapper extends Mapper<LongWritable, InputWritable, Text, IntWritable> {
	private IntWritable one = new IntWritable(1);

	protected void map(LongWritable id, InputWritable value, Context ctx) {
		try {
			boolean fraudTransaction = false;
			if (value.getMasterIcdCode() == null) {
				fraudTransaction = true;
			}
			else {
				// For fraud analysis we want to match at least 80% words in
				// description and diagnosis.
				String diagnosis = value.getDiagnosis();
				String icdDescrp = value.getIcdDescription();

				String[] dClips = icdDescrp.split(" ");

				int wordCount = dClips.length;
				int numberOfMatches = 0;
				for (int i = 0; i < wordCount; i++) {
					if (diagnosis.contains(dClips[i])) {
						numberOfMatches++;
					}
				}

				if ((numberOfMatches * 1.0) / wordCount > 0.8) {
					fraudTransaction = true;
				}
			}

			if (fraudTransaction) {
				String key = value.getBillNumber() + "\t" + value.getFirstName() + "\t" + value.getLastName()
				        + "\t" + value.getBillingDate() + "\t" + value.getDiagnosis() + "\t"
				        + value.getBilledIcdCode();

				ctx.write(new Text(key), one);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
