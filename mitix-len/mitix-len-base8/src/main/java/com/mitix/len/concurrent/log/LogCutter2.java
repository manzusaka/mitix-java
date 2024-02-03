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
public class LogCutter2 {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("/Users/oldflame-jm/Downloads/access1.log"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        double upsTimes = 0.000;
        double wasterTimes = 0.000;
        int count = 0;
        while (line != null) {
            String pattern = "\"request_uri\": \"(\\S+)\"";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            if (m.find()) {
                String s = m.group(1);
                if (!s.startsWith("/signalr")) {
                    String pattern2 = "\"waster_time\": \"(\\S+)\"";
                    String pattern3 = "\"ups_resp_time\": \"(\\S+)\"";
                    Pattern r2 = Pattern.compile(pattern2);
                    Pattern r3 = Pattern.compile(pattern3);
                    Matcher m2 = r2.matcher(line);
                    Matcher m3 = r3.matcher(line);

                    if (m2.find() && m3.find()) {
                        String w = m2.group(1);
                        String u = m3.group(1);
                        try {
                            double dw = Double.parseDouble(w);
                            double du = Double.parseDouble(u);
                            upsTimes = upsTimes + du;
                            wasterTimes = wasterTimes + dw;
                        } catch (Exception e) {

                        }
                        count++;
                    }
                }
            }
            line = reader.readLine();
        }
        double avgWasterTime = wasterTimes / count;
        double avgUpsTime = upsTimes / count;
        System.out.printf("count = %d , avgWasterTime = %f , avgUpsTime = %f \n", count, avgWasterTime, avgUpsTime);
    }
}
