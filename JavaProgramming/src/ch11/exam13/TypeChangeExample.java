package ch11.exam13;

public class TypeChangeExample {

	public static void main(String[] args) {
		
		String v1 = "100";
		
		byte v2 = Byte.parseByte(v1);
		int v3 = Integer.parseInt(v1);
		double v4 = Double.parseDouble(v1);
		
		String v5 = "true";
		boolean v6 = Boolean.parseBoolean(v5);  //해당문자열을 불리언값으로 바꿔줌.
		
		String v7 = String.valueOf(v3);
	}

}
