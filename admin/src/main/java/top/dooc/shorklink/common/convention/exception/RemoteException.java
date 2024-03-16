package top.dooc.shorklink.common.convention.exception;

import top.dooc.shorklink.common.convention.errorcode.BaseErrorCode;
import top.dooc.shorklink.common.convention.errorcode.IErrorCode;

/**
 * @author aaronchen
 * @date 2024/3/16 下午2:06
 */
public class RemoteException extends AbstractException{
    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(IErrorCode errorCode){
        this(null, null, errorCode);
    };

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
