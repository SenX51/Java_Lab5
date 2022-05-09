package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


public class Injector
{
	private String propertyFile = "first.properties";

	public Injector(String _propertyFile)
	{
		propertyFile = _propertyFile;
	}
	public Injector(){}

	public <T> T Inject(T injectee) throws IOException
	{
		try
		{
			Properties properties = new Properties();
			properties.load(new FileInputStream(propertyFile));
			for (Field f : injectee.getClass().getDeclaredFields())
			{
				if (f.isAnnotationPresent(AutoInjectable.class))
				{
					f.setAccessible(true);
					Class<?> _class = Class.forName(properties.getProperty(f.getType().getName()));
					Object _object = _class.getDeclaredConstructor().newInstance();
					f.set(injectee, _object);
				}
			}
		}
		catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
				InvocationTargetException | InstantiationException e)
		{
			System.out.println(e);
		}
		return injectee;
	}
}
