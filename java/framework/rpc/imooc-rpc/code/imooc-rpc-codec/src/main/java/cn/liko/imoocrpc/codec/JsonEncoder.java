package cn.liko.imoocrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * JsonEncoder 基于JSON的序列化实现
 *
 * @author liko
 * @date 2020/7/30 12:16 上午
 */
public class JsonEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
