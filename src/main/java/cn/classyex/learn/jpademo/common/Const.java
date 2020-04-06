/*
 * *
 *
 *     Created by OuYangX.
 *     Copyright (c) 2019, ouyangxian@gmail.com All Rights Reserved.
 *
 * /
 */

package cn.classyex.learn.jpademo.common;

import java.time.ZoneOffset;

/**
 * @date 2020/4/6 16:52 <br>
 * @author yex <br>
 * @version 1.0 <br>
 */
public class Const {


    /**
     * 北京时区
     */
    public static final ZoneOffset BEIJING_ZONE = ZoneOffset.of("+8");
    public static final String DATE_SIMPLE_FMT = "yyyy-MM-dd";

    /**
     * 状态
     */
    public enum Status {
        /**正常 */
        VALID,
        /** 删除 */
        INVALID
    }


}