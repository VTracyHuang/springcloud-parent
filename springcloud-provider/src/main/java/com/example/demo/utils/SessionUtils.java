package com.example.demo.utils;

import com.example.demo.constant.WebConstants;
import com.example.demo.entity.User;
import com.example.demo.exception.AuthFailedException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Session操作 工具类
 */
public final class SessionUtils {


    private static final String SESSION_VALIDATECODE = "session_validatecode";// 验证码

    private static final String SESSION_ACCESS_URLS = "session_access_urls"; // 系统能够访问的URL

    private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; // 系统菜单按钮

    /**
     * 设置session的值
     *
     * @param request
     * @param key
     * @param value
     */
    public static void setAttr(HttpServletRequest request, String key, Object value) {
        WebUtils.setSessionAttribute(request, key, value);
    }

    /**
     * 获取session的值
     *
     * @param request
     * @param key
     */
    public static Object getAttr(HttpServletRequest request, String key) {
        return WebUtils.getSessionAttribute(request, key);
    }

    /**
     * 删除Session值
     *
     * @param request
     * @param key
     */
    public static void removeAttr(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }

    /**
     * 从session中删除用户信息
     *
     * @param request
     * @return SysUser
     */
    public static void removeUser(HttpServletRequest request) {
        removeAttr(request, WebConstants.SESSION_USER);
    }

/*
    */
/**
     * 从session中取出用户信息
     *
     * @param request
     * @return SysUser
     *//*

    @SuppressWarnings("unchecked")
    public static <T> T getUser(HttpServletRequest request) {

//        if(1 == 1){
//            return (T) new GeUser(1,"1",7,2,1);
//        }

        return (T) getAttr(request, WebConstants.SESSION_USER);

    }

    public static <T> T getUser() {
        T user = getUser(((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest());
        if (user == null) {
            throw new AuthFailedException("用户未登录!");
        }
        return user;
    }
*/


    /**
     * 从session中取出用户信息
     *
     * @param request
     * @return SysUser
     */
    public static User getUser(HttpServletRequest request) {
        return (User) getAttr(request, WebConstants.SESSION_USER);
    }

    public static User getUser() {
        User user = SessionUtils.getUser(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        if (user == null) {
            throw new AuthFailedException("用户未登录!");
        }
        return user;
    }
    /**
     * 往session中存入用户信息
     *
     * @param request
     * @return User
     */
    public static void setUser(HttpServletRequest request, Object value) {
        setAttr(request, WebConstants.SESSION_USER, value);
    }

    /**
     * 设置验证码 到session
     *
     * @param request
     * @param user
     */
    public static void setValidateCode(HttpServletRequest request, String validateCode) {
        setAttr(request, SESSION_VALIDATECODE, validateCode);
    }

    /**
     * 从session中获取验证码
     *
     * @param request
     * @return SysUser
     */
    public static String getValidateCode(HttpServletRequest request) {
        return (String) getAttr(request, SESSION_VALIDATECODE);
    }

    /**
     * 从session中获删除验证码
     *
     * @param request
     * @return SysUser
     */
    public static void removeValidateCode(HttpServletRequest request) {
        removeAttr(request, SESSION_VALIDATECODE);
    }

    /**
     * 从session获取sessionId
     *
     * @param request
     * @return SysUser
     */
    public static String getSessionId(HttpServletRequest request) {
        return WebUtils.getSessionId(request);
    }


    /**
     * 设置当前用户能访问的URL
     *
     * @param request
     * @return
     */
    public static void setAccessUrl(HttpServletRequest request, List<String> accessUrls) { // 判断登录用户是否超级管理员
        setAttr(request, SESSION_ACCESS_URLS, accessUrls);
    }

    /**
     * 判断URL是否可访问
     *
     * @param request
     * @return
     */
    public static boolean isAccessUrl(HttpServletRequest request, String url) {
        @SuppressWarnings("unchecked")
        List<String> accessUrls = (List<String>) getAttr(request, SESSION_ACCESS_URLS);
        return accessUrls != null && !accessUrls.isEmpty() && accessUrls.contains(url);
    }

    /**
     * 设置菜单按钮
     *
     * @param request
     * @param btnMap
     */
    public static void setMemuBtnMap(HttpServletRequest request, Map<String, List<String>> btnMap) { // 判断登录用户是否超级管理员
        setAttr(request, SESSION_MENUBTN_MAP, btnMap);
    }

    /**
     * 获取菜单按钮
     *
     * @param request
     * @param btnMap
     */
    @SuppressWarnings("unchecked")
    public static List<String> getMemuBtnListVal(HttpServletRequest request, String menuUri) { // 判断登录用户是否超级管理员
        Map<?, ?> btnMap = (Map<?, ?>) getAttr(request, SESSION_MENUBTN_MAP);
        if (btnMap == null || btnMap.isEmpty()) {
            return null;
        }
        return (List<String>) btnMap.get(menuUri);
    }

    public static void removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

}