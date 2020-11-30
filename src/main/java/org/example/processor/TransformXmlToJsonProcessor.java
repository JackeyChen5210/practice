package org.example.processor;

import cn.hutool.json.XML;
import org.apache.flink.api.common.functions.RichMapFunction;

public class TransformXmlToJsonProcessor extends RichMapFunction<String, String> {
    @Override
    public String map(String xml) throws Exception {
        return XML.toJSONObject(xml, true).toString();
    }
}
