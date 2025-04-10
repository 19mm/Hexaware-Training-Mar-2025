public class ArrayOperation {
	public static void main(String args[]) {
		int arr[] = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;

		int arr1[] = {400, 500, 600};

		System.out.println("Length of Arr: " + arr.length);
		System.out.println("Length of Arr1: " + arr1.length);
		System.out.println();

		System.out.println("Contents of Arr:");
		for (int i : arr) {
			System.out.println(i);
		}

		System.out.println();
		System.out.println("Contents of Arr1:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}
}
