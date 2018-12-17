package com.dikshatech.tst.utilitieslib;


public interface EnumVariables {

	enum SubTypes {
		UNKNOWN, CEO, RMGMANAGER;

		public static SubTypes getValue(String value) {
			try {
				return valueOf(value);
			} catch (Exception e) {
				return UNKNOWN;
			}
		};
	};
}
