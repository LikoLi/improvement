package cn.liko.imoocrpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

public class JsonDecoderTest extends TestCase {

    @Test
    public void testDecode() {
        Encoder encoder = new JsonEncoder();

        TestBean bean = new TestBean();
        bean.setName("imoocrpc");
        bean.setAge(1);

        byte[] bytes = encoder.encode(bean);

        Decoder decoder = new JsonDecoder();
        TestBean decode = decoder.decode(bytes, TestBean.class);
        assertEquals("imoocrpc", decode.getName());
        assertEquals(1, decode.getAge());
    }
}