package ch11.exam02;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id){
		this.id=id;
	}
		//Method
		@Override
		public int hashCode() {
			return id.hashCode();//���ڿ��� ������ �ؽ��ڵ尡 �׻����Ƿ� �̰��� ���Ͻ�Ŵ.
		}
		
	
	@Override
	public boolean equals(Object obj) {    //equals ������.
		if(obj instanceof Member){
			Member target = (Member)obj; // �ڽĿ� �ִ� obj�� ���������� Ÿ�Ժ�ȯ�ؾ���.
			if(id.equals(target.id)){
				return true;
		
			}
		}
			return false;
		}
	}


//if�� ���� �ٽ� Ȯ��!