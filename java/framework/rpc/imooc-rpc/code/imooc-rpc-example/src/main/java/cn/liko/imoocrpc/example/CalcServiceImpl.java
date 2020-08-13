package cn.liko.imoocrpc.example;

/**
 * CalcServiceImpl
 *
 * @author liko
 * @date 2020/8/5
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
