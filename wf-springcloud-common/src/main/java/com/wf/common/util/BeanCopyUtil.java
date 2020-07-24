package com.wf.common.util;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ：wf
 * @Date ：2020/7/23 10:19
 * @Describe：
 */
public class BeanCopyUtil {
    private BeanCopyUtil() {
    }

    public static <T> T copy(Object src, Class<T> clazz) {
        Object t = null;

        try {
            if (src != null) {
                t = clazz.newInstance();
                BeanCopier copier = BeanCopier.create(src.getClass(), clazz, false);
                copier.copy(src, t, (Converter)null);
            }
        } catch (Exception var4) {
        }

        return (T) t;
    }

    public static <T> List<T> copyList(List<?> src, Class<T> clazz) {
        if (src == null) {
            return new ArrayList();
        } else {
            List<T> list = new ArrayList();
            Iterator var3 = src.iterator();

            while(var3.hasNext()) {
                Object obj = var3.next();
                T t = copy(obj, clazz);
                list.add(t);
            }

            return list;
        }
    }

    public static void copy(Object src, Object to) {
        if (src != null && to != null) {
            BeanCopier copier = BeanCopier.create(src.getClass(), to.getClass(), false);

            try {
                copier.copy(src, to, (Converter)null);
            } catch (Exception var4) {
            }

        }
    }
}
