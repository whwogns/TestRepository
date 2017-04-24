package ch11.exam13;

import java.util.Arrays;

public class EqualsExample {

	public static void main(String[] args) {
		int[][] original = {{1,2},{3,4}};
		
		
		System.out.println("[���� ������ ��]");
		int[][] cloned1 = Arrays.copyOf(original, original.length);// (���������� �����ϴµ� , �������� ���̴�� ����)  (������ �迭 ���, �����ؼ� ������ �迭�� ����)
		System.out.println("�迭 ���� ��:"+original.equals(cloned1));// ���������� Ŭ��1�� ��ü�� �ٸ��ٴ� �ǹ�. �� �����Ͽ� ���ο� ��ü�� �����Ȱ�.
		System.out.println("1�� �迭 �׸� �� :"+Arrays.equals(original, cloned1));//���������� Ŭ��1�� ���� �񱳸� �Ͽ�, �������� �����Ƿ� true
		System.out.println("��ø �迭 �׸� �� :"+Arrays.deepEquals(original, cloned1)); // ���������� Ŭ��1�� ���� �񱳸� �Ͽ� ���� ���� �����Ƿ� true
		
		
		System.out.println("\n[���������� ��]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("�迭 ���� �� ;"+original.equals(cloned2));
		System.out.println("1�� �迭 �׸� ��:"+Arrays.equals(original, cloned2));
		System.out.println("��ø �迭 �׸� �� :"+Arrays.deepEquals(original, cloned2));

	}

}
