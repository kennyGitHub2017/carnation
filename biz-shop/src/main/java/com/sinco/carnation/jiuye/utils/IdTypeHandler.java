package com.sinco.carnation.jiuye.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实体层的id主键使用String，db schema则使用long自增。本类则负责其间的可逆加密转换。
 * 
 * @author lx
 */
public final class IdTypeHandler  {
    final static Logger log = LoggerFactory.getLogger(IdTypeHandler.class);

    public static void main(String[] args) {
//        System.out.println("100:" + encode(100));
//        System.out.println("13:" + encode(13));
//        System.out.println("29401:" + encode(29401));
//        
//        System.out.println("65191:" + encode(65191));
//        System.out.println("c9z3xgq7:" + decode("c9z1a7jb"));
//        System.out.println("1k6x9:" + decode("1k6x9"));
        System.out.println("1k6x9:" + decode("1k6x9"));
    }

    /**
     * long -> string 混淆加密 如果是特殊Id(带负号)，则原值返回 by lx
     * 
     * @param l
     * @return
     */
    public static String encode(long l) {
        if (l < 0)
            return Long.toString(l);
        // log.error("Fatal: id混淆超界");
        else {
            l = mix(l);
            return Long.toString(l, 36);
        }
    }

    /**
     * string -> long 解密 如果是特殊Id(带负号)，则原值返回 by lx
     * 
     * @param s
     * @return
     */
    public static long decode(String s) {
        if (s.startsWith("-"))
            return Long.parseLong(s);
        else
            return demix(Long.parseLong(s, 36));
    }

    /**
     * 带版本的混淆
     */
    private static long mix(long l) {
        long[] vs = doMix(l);
        return setVersion(vs);
    }

    /**
     * 当前版本的mix算法. <b>注意不要数值越界成负数</b>
     */
    private static long[] doMix(long l) {
        final long version = 1L; // 当前混淆算法版本号

        // 8进制位
        long ret = l;
        int digit = 0;
        while (ret > 0) {
            digit++;
            ret = ret >> 3;
        }
        // 每5位插值, 插值位
        int i = 0, md = (digit - 1) / 5 + 1, mix = (int) (l & ((1 << (3 * md)) - 1));
        ret = 0;
        while (digit > 0) {
            ret += (((l & ((1 << 15) - 1)) + ((mix & (((1 << 3) - 1) << (3 * --md))) << (15 - 3 * md))) << i);
            l = (l >> 15);
            digit -= 5;
            i += 18;
        }
        l = ret;

        return new long[] { version, l };
    }

    private static long demix(long l) {
        long[] vs = getVersion(l);
        l = vs[1];
        switch ((int) vs[0]) {
            case 1:
                long dig = 0, ret = 0;
                while (l > 0) {
                    ret += ((l & ((1 << 15) - 1)) << dig);
                    l = (l >> 18);
                    dig += 15;
                }
                l = ret;
                break;
        }
        return l;
    }

    /**
     * 16进制下，将版本号保留在百位数
     * 
     * @param [version, value]
     */
    private static long setVersion(long[] vs) {
        // return vs[1] / 256 * 4096 + vs[0] * 256 + vs[1] % 256;
        return ((vs[1] >> 8) << 12) + (vs[0] << 8) + (vs[1] & 255);
    }

    /**
     * 16进制下，将版本号保留在百位
     * 
     * @return [version, value]
     */
    private static long[] getVersion(long l) {
        // return new long[] { (l / 256) % 16, (l / 4096) * 256 + l % 256 };
        return new long[] { (l >> 8) & 15, ((l >> 12) << 8) + (l & 255) };
    }

   

}
