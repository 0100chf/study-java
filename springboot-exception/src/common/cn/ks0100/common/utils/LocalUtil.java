package cn.ks0100.common.utils;

import java.util.Locale;

/**
 * 国际化工具类
 * @author chen haifeng
 *
 */
public class LocalUtil {

 // private final static ThreadLocal<String> tlUser = new ThreadLocal<String>();

  private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
    protected Locale initialValue() {
      // 语言的默认值
      return Locale.CHINESE;
    };
  };

  //public static final String KEY_LANG = "lang";

 // public static final String KEY_USER = "user";


  public static void setLocale(String locale) {
    setLocale(new Locale(locale));
  }

  public static void setLocale(Locale locale) {
    tlLocale.set(locale);
  }

  public static Locale getLocale() {
    return tlLocale.get();
  }


}
