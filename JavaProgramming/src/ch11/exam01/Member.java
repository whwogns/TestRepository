package ch11.exam01;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id){
		this.id=id;
	}
	//Method
	@Override
	public boolean equals(Object obj) {    //equals ������.
		if(obj instanceof Member){
			Member target = (Member)obj; // �ڽĿ� �ִ� obj�� ���������� Ÿ�Ժ�ȯ�ؾ���.
			if(id.equals(target)){
				return true;
		
			}
		}
			return false;
		}
	}


//if�� ���� �ٽ� Ȯ��!