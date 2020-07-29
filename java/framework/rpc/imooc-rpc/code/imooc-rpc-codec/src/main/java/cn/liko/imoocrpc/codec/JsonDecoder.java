package cn.liko.imoocrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * JSONDecoder 基于JSON的反序列化
 *
 * @author liko
 * @date 2020/7/30 12:18 上午
 */
public class JsonDecoder implements Decoder {

    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
