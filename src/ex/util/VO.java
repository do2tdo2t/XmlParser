/**
 * 
 */
package ex.util;

import java.util.Map;

/**
 * @author Uxxxxxxx
 *
 */
public abstract class VO {
	
	public void mapToVo(Map<String,Object> map) throws Exception
	{
		java.lang.reflect.Field[] fields = this.getClass().getDeclaredFields();
		java.lang.reflect.Field field;
		String key;
		Object value;
		
		for(int i = 0 ; i < fields.length ; i++)
		{
			field = fields[i];
			if(field != null)
			{
				key = convertFieldNameTokey(field.getName());
				if(map.containsKey(key))
				{
					field.setAccessible(true);
					value = map.get(key);
					if(value.getClass().equals(field.getClass()))
					{
						field.set(this, value);
					}
					field.setAccessible(false);
				}
			}
		}
	}
	
	public String convertFieldNameTokey(String fieldName)
	{
		StringBuilder sb = new StringBuilder();
		char c;
		
		for(int i = 0 ; i < fieldName.length() ; i++)
		{
			c = fieldName.charAt(i);
			if(Character.isUpperCase(c))
			{
				sb.append("_"+c);
			}
			else
			{
				sb.append(Character.toUpperCase(c));
			}
		}
		return sb.toString();
	}
}
