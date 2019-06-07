
import java.util.*;

public class Pair_From_Array
{ 
	public static void main(String args[]){
		Scanner sc =  new Scanner(System.in);
		try{
			// Requesting user to enter the size of the array
			System.out.println("Please enter the size of sorted numeric array;");
			// Importing scanner class to extract user input


			// Integer Array to store the values 
			int user_array[] = new int[sc.nextInt()]; 


			// Requesting user to provide with the value of sorted array. 
			System.out.println("Please enter the sorted values of the array");


			// It is assumed that user will enter sorted values for the array. 
			// However checking the entered value is greater than previous value or not. 
			// In case not promoting user to enter value again. 
			// Directly taking the first value. Will only check after the first value.  
			for(int i = 0; i< user_array.length; i ++){

				if (i != 0){

					int temp = sc.nextInt();
					if ( user_array[i-1] < temp){

						user_array[i] = temp;
						System.out.println("Enter next number :");
					}
					else{
						System.out.println("Invalid entry, please re-enter");
						user_array[i] = sc.nextInt();
						System.out.println("Enter next number :");
					}
				}
				else{
					user_array[i] = sc.nextInt();
					System.out.println("Enter next number : \n");

				}
			}
			// Printing the sorted array
			System.out.println("Entered sorted array is :\n " + Arrays.toString(user_array));

			System.out.println("Please enter the numbers whose pair needed to find ");

			// Requesting user to enter the number whose closest pair match is be founded.
			int number  = sc.nextInt();
			// Printing the entered number
			System.out.println("Entered number is:" + number);

			// If the entered array is of length less than 2 than automatically the closest match is the two number. 
			if (user_array.length > 2 ){

				// If the number entered is less than the sum of fist two numbers. Than the closest pair is first two mnumber only. 
				// Checking this and returning the first two numbers of the number is less than the sum of first two number 
				if (number < (user_array[0] + user_array[1])){

					System.out.println("Closest pair for the entered number in the array are :  " + user_array[0] + "    and " + user_array[1]);
				}
				// If the number entered is more than the sum of last two numbers. Than the closest pair is last two number only. 
				// Checking this and returning the last two numbers of the number is greater than the sum of last two number 
				else if( number > (user_array[user_array.length - 1] + user_array[user_array.length - 2])){
					System.out.println("Closest pair for the entered number in the array are :  " + user_array[user_array.length - 2] 
							+ "    and " + user_array[user_array.length - 1]);

				}else {
					// if above both conditions doesn't match, sham finding the pair. 
					// Setting first index as 0 and second as 1
					// calculating the difference and setting the minimum as the difference of number with the first two values of array.//
					// Since the difference can be negative as well in case the number is very high the addition of first two elements, converting it to positive. 
					int index_1 = 0;
					int index_2 = 1;
					int diff = Math.abs(user_array[index_1] + user_array[index_2] - number);
					// Reading values in two indexes of the array 
					for (int i = 0; i < user_array.length -1 ; i++){
						// Second loop for second index, starting the loop from the next index from the first index to last index of the array
						for(int j = i + 1  ;  j < user_array.length; j++){
							// if the previous difference is higher than the current index difference, Setting the new index and setting the new difference as
							// we need to find the minimum difference. 
							if (diff > Math.abs( user_array[i] + user_array[j] - number )){
								index_1 = i;
								index_2 =j;
								diff =Math.abs( user_array[i] + user_array[j] - number ); 
							}

						}
					}
					// Once all the pairs are compared printing the one with minimum difference. 
					System.out.println("Closest pair for the entered number in the array are :  " + user_array[index_1] 
							+ "    and " + user_array[index_2]);
				}

			} else if (user_array.length == 2){
				// IF the entered array is of length two than both the elements are the closest pair. 
				System.out.println("Closest pair for the entered number in the array are :  " + user_array[0] + "    and " + user_array[1]);
			}

			else {
				// If the array length is less than 2, we cannot find the pair. 
				System.out.print("The entered array is of lenght less than 2, hence no pair can be found");
			}
		}catch( Exception ex){
			// NOT HANDILNG ANY ERROR, HOWEVER IN CASE OF ANY ERROR, PRINTING THE ERROR
			System.out.print("Error occured: " + ex);
		}
		finally {
			sc.close();
		}
	}
}
