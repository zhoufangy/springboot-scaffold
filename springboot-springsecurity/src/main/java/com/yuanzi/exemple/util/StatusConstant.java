package com.yuanzi.exemple.util;

/**
 * Created by ZuoYun on 26/06/2017.
 * Time: 11:31 AM
 * Information:
 */

public enum StatusConstant {

  /**
   * 成功
   */
  SUCCESS(200, "成功"),

  /**
   * 没有登录
   */
  NOT_LOGIN(4001, "没有登录"),

  /**
   * 没有登录
   */
  LOGIN_FAIL(4006, "登录失败"),

  /**
   * 未授权
   */
  NO_AUTH(4444, "未授权"),

  /**
   * 必须为数字
   */
  PAGE_ERROR(4005, "分页参数异常"),

  /**
   * 分页异常
   */
  NUM_ERROR(4003, "分页异常"),

  /**
   *
   */
  EXCEPTION(4001, "发生异常"),

  /**
   * 系统错误
   */
  SYS_ERROR(4004, "系统错误"),

  /**
   * 参数错误
   */
  PARAMS_ERROR(4002, "参数错误 "),

  /**
   * 不支持或已经废弃
   */
  NOT_SUPPORTED(4100, "不支持或已经废弃"),

  /**
   * AuthCode错误
   */
  INVALID_AUTHCODE(4440, "无效的AuthCode"),

  /**
   * 太频繁的调用
   */
  TOO_FREQUENT(4003, "太频繁的调用"),

  /**
   * 未知的错误
   */
  UNKNOWN_ERROR(4990, "未知错误");

  private StatusConstant(Integer value, String msg) {
    this.val = value;
    this.msg = msg;
  }

  public Integer val() {
    return val;
  }

  public String msg() {
    return msg;
  }

  private Integer val;
  private String  msg;

}
