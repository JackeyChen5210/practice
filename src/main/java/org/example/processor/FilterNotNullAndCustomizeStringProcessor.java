package org.example.processor;

import org.apache.flink.api.common.functions.FilterFunction;

/**
 * When message contains any symbol of the inputs symbols
 * return true
 * When input symbols is null or empty
 * this processor just filter null or empty input content
 * @author jack
 */
public class FilterNotNullAndCustomizeStringProcessor implements FilterFunction<String> {

    private String[] symbols;

    public FilterNotNullAndCustomizeStringProcessor(String... symbols) {
        this.symbols = symbols;
    }

    @Override
    public boolean filter(String s) throws Exception {
        if (s == null || "".equals(s)) {
            return false;
        }

        if (symbols == null || symbols.length == 0) {
            return true;
        }

        boolean shouldSend = false;
        for (String symbol : symbols) {
            shouldSend = shouldSend || s.contains(symbol);
        }
        return shouldSend;
    }
}
