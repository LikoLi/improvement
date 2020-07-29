package cn.liko.imoocrpc.codec;

/**
 * Decoder 反序列化
 *
 * @author liko
 * @date 2020/7/30 12:14 上午
 */
public interface Decoder {

    /**
     * 反序列化对象
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T decode(byte[] bytes, Class<T> clazz);
}
