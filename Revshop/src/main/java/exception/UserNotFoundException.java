package exception;

public class UserNotFoundException extends RuntimeException{
	public String toString() {
	return "User Doesn't Exist";
	}

}
