package com.mitix.len.concurrent.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author oldflame-jm
 * @create 2018/6/11
 * ${DESCRIPTION}
 */
public class LogCutter3 {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("/Users/oldflame-jm/Downloads/access.log"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        Map<String, Long> tmap = new HashMap<>();
        Map<String, Long> cmap = new HashMap<>();
        while (line != null) {
            String pattern = "\"resp_len\": \"(\\d+)\", \"content_type\": \"(\\S*)\"";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            if (m.find()) {
                String size = m.group(1);
                String content = m.group(2);
                if (StringUtil.isEmpty(content)) {
                    content = "local";
                }
                content = content.split(";")[0];
                try {
                    Long contentTotal = tmap.get(content);
                    if (contentTotal == null) {
                        contentTotal = 0L;
                        tmap.put(content, contentTotal);
                    }
                    Long contentCount = cmap.get(content);
                    if (contentCount == null) {
                        contentCount = 0L;
                        cmap.put(content, contentCount);
                    }
                    long sizelong = Long.parseLong(size);
                    contentTotal = contentTotal + sizelong;
                    contentCount = contentCount + 1;
                    tmap.replace(content, contentTotal);
                    cmap.replace(content, contentCount);
                } catch (Exception e) {

                }
            }
            line = reader.readLine();
        }
        for (Map.Entry<String, Long> entry : tmap.entrySet()) {
            double avg = 0.00;
            String key = entry.getKey();
            Long value = entry.getValue();
            long count = cmap.get(key);
            if (count > 0) {
                avg = value / count;
            }
            System.out.printf("this key = %s and this avg = %f\n", key, avg);
        }
    }
}
