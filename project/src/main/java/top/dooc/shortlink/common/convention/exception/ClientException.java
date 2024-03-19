package top.dooc.shortlink.common.convention.exception;

import top.dooc.shortlink.common.convention.errorcode.BaseErrorCode;
import top.dooc.shortlink.common.convention.errorcode.IErrorCode;

/**
 * @author aaronchen
 * @date 2024/3/16 下午2:03
 */
public class ClientException extends AbstractException{
    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
