package com.ibm.logic;

import java.io.IOException; 
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.Mapper;  
public class MaxTempMapper extends Mapper<LongWritable, Text, Text, IntWritable> {  
   @Override    
   public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
   
   {  
	   String line = value.toString(); 
	   String month = line.substring(22,24); 
	   int avgTemp; avgTemp = Integer.parseInt(line.substring(95,98)); 
	   context.write(new Text(month), new IntWritable(avgTemp)); 
   
   }
}