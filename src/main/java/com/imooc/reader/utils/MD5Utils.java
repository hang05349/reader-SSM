package com.imooc.reader.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/23 20:55]
 * Description   : [混淆原始数据]
 */
public class MD5Utils {
    public static String md5Digest(String source,Integer salt){
        char[] ca = source.toCharArray();
        for (int i = 0; i <ca.length ; i++) {
            ca[i] = (char)(ca[i]+salt);
        }
        String target = new String(ca);
        return DigestUtils.md5Hex(target);
    }
}
