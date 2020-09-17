package com.example.demo.constant;

/**
 * 常量定义
 */
public class WebConstants {

    /**
     * 保存SESSION的变量
     */
    public static final String SESSION_USER = "session_user";

    /**
     * 所有userId和sessionId的对应关系，保存到context中
     */
    public static final String ALL_USER_SESSION = "user_session_map";

    /**
     * 格式化日期yyyy-MM-dd HH:mm
     */
    public static final String FORMAT_DATE_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * 保存在session中的TOKEN变量名称
     */
    public static final String SESSION_TOKEN = "session_token";

    /**
     * 保存在session中的发送手机验证码的电话号码
     */
    public static final String SMS_VERIFY_USER = "sms_verify_user";

}
