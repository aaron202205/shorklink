package top.dooc.shortlink.toolkit;

import cn.hutool.core.lang.hash.MurmurHash;
import top.dooc.shortlink.common.convention.exception.ClientException;

import static top.dooc.shortlink.common.convention.errorcode.BaseErrorCode.CLIENT_ERROR;


/**
 * @author aaronchen
 * @date 2024/3/19 下午3:03
 */
public class HashUtil {
    private static final char[] CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private static final int SIZE = CHARS.length;
    private static String convertDecToBase62(long num)
    {
        StringBuilder sb = new StringBuilder();
        while (num > 0)
        {
            sb.append(CHARS[(int) (num % SIZE)]);
            num = num / SIZE;
        }
        return sb.reverse().toString();
    }
    public static String hashToBase62(String str){
        if (str == null) {
            throw new ClientException(CLIENT_ERROR);
        }
        int i = MurmurHash.hash32(str);
        long num = i<0 ? Integer.MAX_VALUE - (long) i : i ;
        return convertDecToBase62(num);
    }
}
