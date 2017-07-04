package com.meedesidy.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.meedesidy.entity.enumtype.BaseEnum;

final class StringToEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

	@Override
	public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class StringToEnum<T extends BaseEnum> implements Converter<String, T> {  
		   
       private final Class<T> enumType;  
   
       public StringToEnum(Class<T> enumType) {  
           this.enumType = enumType;  
       }  
   
       public T convert(String source) {  
           if (source.length() == 0) {  
              // It's an empty enum identifier: reset the enum value to null.  
              return null;  
           }  
           return (T) new BaseEnum();  
       }  
	
	}  
	
}
