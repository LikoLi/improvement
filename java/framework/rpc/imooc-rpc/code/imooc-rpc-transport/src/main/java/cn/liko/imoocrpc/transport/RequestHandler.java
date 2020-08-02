package cn.liko.imoocrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * RequestHandler 处理网络请求
 *
 * @author liko
 * @date 2020/8/1
 */
public interface RequestHandler {

    void onRequest(InputStream inputStream, OutputStream outputStream);

}
