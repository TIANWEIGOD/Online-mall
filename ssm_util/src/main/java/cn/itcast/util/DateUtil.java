package cn.itcast.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String FormatDatetoStr(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return sdf.format(date);

    }

}
