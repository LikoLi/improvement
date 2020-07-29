package cn.liko.imoocrpc.codec;

/**
 * Encoder 序列化
 *
 * @author liko
 * @date 2020/7/30 12:13 上午
 */
public interface Encoder {

    /**
     * 序列化对象
     * @param obj
     * @return
     */
    byte[] encode(Object obj);
}
