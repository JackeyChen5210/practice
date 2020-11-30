package org.example.job;

import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.processor.FilterNotNullAndCustomizeStringProcessor;
import org.example.processor.TransformXmlToJsonProcessor;
import org.example.sink.FileSink;
import org.example.source.FileSource;

import java.util.concurrent.TimeUnit;

/**
 * @author jack
 */
public class FirstJobTest {
    public static void main(String[] args) throws Exception {


        StreamExecutionEnvironment env = environment();

        SingleOutputStreamOperator<String> source = env.addSource(new FileSource("/in/1.txt"))
                .map(new TransformXmlToJsonProcessor())
                .filter(new FilterNotNullAndCustomizeStringProcessor());
        source.addSink(new FileSink("/out/2.txt"));

        env.execute(FirstJobTest.class.getName());
    }

    private static StreamExecutionEnvironment environment() {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRestartStrategy(RestartStrategies.fixedDelayRestart(3, Time.of(10, TimeUnit.SECONDS)));
        env.enableCheckpointing(1000);
        ExecutionConfig config = env.getConfig();
        System.out.println(config);
        return env;
    }

}
