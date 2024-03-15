package top.dooc.shorklink.common.enums;

import top.dooc.shorklink.common.convention.errorcode.IErrorCode;

/**
 * @author aaronchen
 * @date 2024/3/15 下午8:18
 */
public enum UserErrorCodeEnums implements IErrorCode {
    USER_NULL("B000200", "用户不存在"),
    USER_EXIST("B000201", "用户已存在");


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
