package com.meedesidy.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.meedesidy.entity.enumtype.CodeBaseEnum;

public class EnumTypeHandler<E extends Enum<?> & CodeBaseEnum> extends BaseTypeHandler<CodeBaseEnum> {
	private Class<E> clazz;
	
	 public EnumTypeHandler(Class<E> enumType) {
	        if (enumType == null)
	            throw new IllegalArgumentException("Type argument cannot be null");
	 
	        this.clazz = enumType;
	    }
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, CodeBaseEnum parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(i, parameter.code());
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return CodeEnumUtil.codeOf(clazz, rs.getInt(columnName));
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		 return CodeEnumUtil.codeOf(clazz, rs.getInt(columnIndex));
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return CodeEnumUtil.codeOf(clazz, cs.getInt(columnIndex));
	}

}
