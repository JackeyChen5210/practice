package org.example.sink;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.example.util.FileUtil;

public class FileSink implements SinkFunction<String> {
    private String filePath;

    public FileSink(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void invoke(String value, Context context) throws Exception {
        FileUtil.writeFile(filePath,value);
    }
}
