package com.test.day2022;

/**
 * @Package: com.test.day2022
 * @ClassName: ToBigDecimalFunction
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/7 0:21
 */
import java.math.BigDecimal;

@FunctionalInterface
public interface ToBigDecimalFunction<T> {
    BigDecimal applyAsBigDecimal(T value);
}
