package com.wf.common.dto;

/**
 * 响应返回代码枚举
 */
public class RetCode {

    // 系统级通用返回代码，范围：[0,-N]
    public static final RetCode SUCCESS = new RetCode("0", "成功");
    public static final RetCode FAILURE = new RetCode("-1", "失败");
    public static final RetCode DUPLICATE = new RetCode("-2", "请求重复提交");
    public static final RetCode FREQUENT = new RetCode("-3", "过高频次访问");
    public static final RetCode LOCKED = new RetCode("-4", "资源占用锁定");
    public static final RetCode SERVER_NOT_FOUND = new RetCode("-5", "服务未发现");
    public static final RetCode SERVER_NOT_AVAILABLE = new RetCode("-6", "服务不可用");
    public static final RetCode OFFLINE = new RetCode("-7", "网络异常断线");
    public static final RetCode TIMEOUT = new RetCode("-8", "连接超时错误");
    public static final RetCode EXCEPTION = new RetCode("-9", "未知系统异常");

    // 业务级通用错误代码，范围：[10,99]
    public static final RetCode ERR_PROTOCOL = new RetCode("-10", "协议约定错误");
    public static final RetCode ERR_SIGNATURE = new RetCode("-11", "签名验证错误");
    public static final RetCode ERR_ENCRYPT = new RetCode("-12", "加密解密异常");
    public static final RetCode ERR_AUTHORITY = new RetCode("-13", "访问认证错误");
    public static final RetCode ERR_PERMISSION = new RetCode("-14", "权限许可不足");
    public static final RetCode ERR_VALID_PARAM = new RetCode("-21", "参数校验错误");
    public static final RetCode ERR_VALID_DATA = new RetCode("-22", "数据校验错误");
    public static final RetCode ERR_VALID_LOGIC = new RetCode("-23", "逻辑校验错误");
    public static final RetCode ERR_PARAM_NULL = new RetCode("-24", "请求参数为空");
    public static final RetCode PARAM_INVALID = new RetCode("-25", "参数校验错误");
    public static final RetCode ERR_SAVE_FAILURE = new RetCode("-26", "保存数据失败");
    public static final RetCode ERR_UPDATE_FAILURE = new RetCode("-27", "更新数据失败");
    public static final RetCode ERR_DELETE_FAILURE = new RetCode("-28", "删除数据失败");
    public static final RetCode ERR_RETURNDATA_NULL = new RetCode("-29", "查询数据为空");
    public static final RetCode ERR_ENTITY_NULL = new RetCode("-30", "实例不存在");
    public static final RetCode ERR_APP_ID_NULL = new RetCode("-31", "应用id为空");
    public static final RetCode ERR_APP_RETURN = new RetCode("-32", "应用返回为null,或者retCode不是success");
    public static final RetCode ERR_APP_NOT_EXISTS = new RetCode("-33", "应用不存在");
    public static final RetCode ERR_NOT_LOGGED_IN = new RetCode("-34", "未登录");
    public static final RetCode ERR_GAIN_TOKEN_EXCEPTION = new RetCode("-35", "获取token异常");
    public static final RetCode ERR_GAIN_TOKEN_NOT_SUCCESS = new RetCode("-36", "获取token返回不成功");



    // 代码
    private String code;

    // 默认信息
    private String msg;

    /**
     * 构造方法
     *
     * @param code 代码
     * @param msg  默认信息
     */
    protected RetCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

