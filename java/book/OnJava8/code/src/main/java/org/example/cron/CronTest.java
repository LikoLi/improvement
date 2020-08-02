package org.example.cron;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * CronTest
 *
 * @author liko
 * @date 2020/7/27
 */
public class CronTest {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        CronSequenceGenerator generator = new CronSequenceGenerator("0 0 4 1/1 8/1 ?");
        for (int i = 0; i < 365; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date next = generator.next(calendar.getTime());
            System.out.println(format.format(next));
        }
    }
}
