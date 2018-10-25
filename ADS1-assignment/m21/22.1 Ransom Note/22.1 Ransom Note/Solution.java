import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		SeparateChainingHashST<String, Integer> hashobj = new SeparateChainingHashST<String, Integer>();
		String[] length = sc.nextLine().split(" ");
		String[] s1 = sc.nextLine().split(" ");
		for(int i = 0; i < s1.length;i++) {
			if(hashobj.contains(s1[i])) {
				hashobj.put(s1[i], hashobj.get(s1[i])+1);
			}else{
				hashobj.put(s1[i],1);
			}
		}
		String[] s2 = sc.nextLine().split(" ");
		for(int i = 0;i<s2.length;i++) {
			if(hashobj.contains(s2[i])) {
				if(hashobj.get(s2[i])==0){
					System.out.println("No");
					return;
				}else{
					hashobj.put(s2[i],hashobj.get(s2[i])-1);
				}
			}else{
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}