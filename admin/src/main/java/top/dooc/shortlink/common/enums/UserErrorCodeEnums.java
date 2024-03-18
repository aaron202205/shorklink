package top.dooc.shortlink.common.enums;

import top.dooc.shortlink.common.convention.errorcode.IErrorCode;

/**
 * @author aaronchen
 * @date 2024/3/15 下午8:18
 */
public enum UserErrorCodeEnums implements IErrorCode {
    USER_NULL("B000200", "用户记录不存在"),
    USER_NAME_EXIST("B000201", "用户名已存在"),
    USER_EXIST("B000202", "用户记录已存在"),
    USER_SAVE_ERROR("B000203", "用户记录新增失败");


    private final String code;

    private final String message;

    UserErrorCodeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
