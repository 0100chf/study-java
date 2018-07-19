package cn.xiaowenjie.common.utils;

import java.util.Locale;

import org.slf4j.MDC;

import cn.xiaowenjie.common.exceptions.UnloginException;

/**
 * 用户工具类
 * 
 * @author 晓风轻 https://xwjie.github.io/PLMCodeTemplate/
 *
 */
public class UserUtil {

  private final static ThreadLocal<String> tlUser = new ThreadLocal<String>();

  private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
    protected Locale initialValue() {
      // 语言的默认值
      return Locale.CHINESE;
    };
  };

  public static final String KEY_LANG = "lang";

  public static final String KEY_USER = "user";

  public static void setUserToken(String token,String userName) {
    tlUser.set(token);

    // 把用户信息放到log4j
    MDC.put(KEY_USER, userName);
  }

  /**
   * 如果没有登录，返回null
   * 
   * @return
   */
  public static String getUserTokenIfLogin() {
    return tlUser.get();
  }

  /**
   * 如果没有登录会抛出异常
   * 
   * @return
   */
  public static String getUserToken() {
    String token = tlUser.get();

    if (token == null) {
      throw new UnloginException();
    }

    return token;
  }

  public static void setLocale(String locale) {
    setLocale(new Locale(locale));
  }

  public static void setLocale(Locale locale) {
    tlLocale.set(locale);
  }

  public static Locale getLocale() {
    return tlLocale.get();
  }

  public static void clearAllUserInfo() {
    tlUser.remove();
    tlLocale.remove();

    MDC.remove(KEY_USER);
  }
}
