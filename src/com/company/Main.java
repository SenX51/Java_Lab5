// Семенов Арсений Владимирович, ФИИТ, 3 курс, 62 группа, лабораторная №5

package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
	{
		System.out.println("Файл настроек: first.properies\nВывод:");
		BaseClass base = new Injector().Inject(new BaseClass());
		base.Func();

		System.out.println("\nФайл настроек: second.properies\nВывод:");
		BaseClass baseSec = new Injector("second.properties").Inject(new BaseClass());
		baseSec.Func();
	}
}
