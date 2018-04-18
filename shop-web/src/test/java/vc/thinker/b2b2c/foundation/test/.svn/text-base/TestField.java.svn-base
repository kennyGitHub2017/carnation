package vc.thinker.b2b2c.foundation.test;

import java.beans.PropertyDescriptor;

import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.tools.CommUtil;

public class TestField {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String field = "store.grade";
		if (field.indexOf(".") > 0) {
			Class entity = Class.forName("vc.thinker.b2b2c.domain."
					+ CommUtil.first2upper(field.substring(field.indexOf("_") + 1, field.indexOf("."))));
			// System.out.println(entity);
			String propertyName = field.substring(field.indexOf(".") + 1);
			System.out.println("属性值:" + propertyName);
			BeanWrapper entity_wrapper = new BeanWrapper(entity);
			java.beans.PropertyDescriptor[] entity_propertys = entity_wrapper.getPropertyDescriptors();
			for (PropertyDescriptor pd : entity_propertys) {
				if (pd.getName().equals(propertyName)) {
					System.out.println(pd.getName());
				}
				// System.out.println(pd.getName());
			}
		}
	}

}
