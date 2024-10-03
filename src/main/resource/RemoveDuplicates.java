
public class RemoveDuplicates {
	
	public static void main(String[]args) {
		//Print duplicate word
		
		String s="iamindian";
		char[]arr=s.toCharArray();
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j]) {
					arr[j]=0;
					
				}
			}
			if(arr[i]!=0) {
				System.out.println(arr[i]);
			}
		}

}
}