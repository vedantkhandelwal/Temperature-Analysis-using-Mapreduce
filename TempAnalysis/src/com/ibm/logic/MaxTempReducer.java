package com.ibm.logic;

import java.io.IOException; 
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Reducer;  
public class MaxTempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {   
	@Override    
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException 
	{   
		int maxTemp = Integer.MIN_VALUE; 
		for (IntWritable value: values) 
		{ maxTemp = Math.max(maxTemp, value.get()); } 
		context.write(key, new IntWritable(maxTemp)); 
		
	} 
}