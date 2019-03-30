package com.pkgs.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-30 13:49
 * <p>
 * @since 1.0.0
 */
public class DateUtil {


    public static String format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(new Date());
    }
}
