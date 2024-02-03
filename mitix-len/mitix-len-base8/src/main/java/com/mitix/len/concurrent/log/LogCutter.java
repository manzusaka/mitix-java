package com.mitix.len.concurrent.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author oldflame-jm
 * @create 2018/6/11
 * ${DESCRIPTION}
 */
public class LogCutter {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("/Users/oldflame-jm/Downloads/access.log"));
        File file = FileUtil.createFile("/Users/oldflame-jm/Downloads/access1.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        Map<String, Long> tmap = new HashMap<>();
        Map<String, Long> cmap = new HashMap<>();
        List<String> lines = new ArrayList<>();
        while (line != null) {
            String pattern = "\"server_name\": \"(\\S+)\"";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            if (m.find()) {
                String s = m.group(1);
                if (s.equals("c.geely.com")) {
                    lines.add(line);
                }
            }
            line = reader.readLine();
        }
        FileUtil.writeLines(lines,"/Users/oldflame-jm/Downloads/access1.log","\n","utf-8",false);
    }
}
