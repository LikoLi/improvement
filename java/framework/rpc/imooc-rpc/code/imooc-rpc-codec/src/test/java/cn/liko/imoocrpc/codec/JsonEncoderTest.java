package cn.liko.imoocrpc.codec;

import junit.framework.TestCase;
import lombok.Data;
import org.junit.Test;

public class JsonEncoderTest extends TestCase {

    @Test
    public void testEncode() {
        Encoder encoder = new JsonEncoder();

        TestBean bean = new TestBean();
        bean.setName("imoocrpc");
        bean.setAge(1);

        byte[] encode = encoder.encode(bean);
        assertNotNull(encode);
    }
}

