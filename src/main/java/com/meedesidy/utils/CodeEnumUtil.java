package com.meedesidy.utils;

import com.meedesidy.entity.enumtype.CodeBaseEnum;

public class CodeEnumUtil {
	public static <E extends Enum<?> & CodeBaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.code() == code)
                return e;
        }
        return null;
    }
}
