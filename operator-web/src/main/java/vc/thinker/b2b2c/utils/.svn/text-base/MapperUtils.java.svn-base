package vc.thinker.b2b2c.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

/**
 * bean 映射工具类
 * 
 * @author james
 * 
 */
public class MapperUtils {

	public static <T, U> ArrayList<U> map(final Mapper mapper, final List<T> source, final Class<U> destType) {

		final ArrayList<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(mapper.map(element, destType));
		}

		return dest;
	}
}
