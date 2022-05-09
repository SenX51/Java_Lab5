package com.company;

public class BaseClass
{
	@AutoInjectable
	private InterfaceA interfaceA;
	@AutoInjectable
	private InterfaceB interfaceB;

	public void Func()
	{
		interfaceA.IA_DoSmth();
		interfaceB.IB_DoSmth();
	}
}
