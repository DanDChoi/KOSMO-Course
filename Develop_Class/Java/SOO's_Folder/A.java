package aa.bb; //(1)��Ű�� ���� 

import java.lang.*; //(2) ����Ʈ ���� 
import java.util.*;

public class A{ //(3) Ŭ���� ���� 
	Random r = new Random(); //(4) ������� 
	String shape = "�߻��� "; //�Ӽ�(member variable)
    public A(){ //(5) ������(Constructor)
		System.out.print(shape + "��ö�̰� ");
	}
	public void m(){ //(6) �޼ҵ�(Method) 
		System.out.print("�޸���");
	}
}