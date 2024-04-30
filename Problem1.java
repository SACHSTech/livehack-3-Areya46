class Problem1 extends ConsoleProgram {

  /**
  * This code takes the users first name, last name, and student number to generate a user name for them. It also checks to see if the password they created is valid.
  * @author: A.Emmanuel-Singh
  */
  
  // Variables 
  String userName = "";
  String inputPassword;
  /**
   * 
   * Takes user input and calls upon methods to output a combination of user responses
   * 
   */
  public void run() {
    
    System.out.println("***** Student Account Registration *****");
    String firstNameInput = readLine("Enter your first Name: ");
    String LastNameInput = readLine("Enter your last Name: ");
    String digitsInput = readLine("Enter your student number: ");
    inputPassword = readLine("Enter a new password: ");
    System.out.println("Your username is: " + createUserName(firstNameInput, LastNameInput, digitsInput));
    System.out.println("Valid password: " + validatePassword(inputPassword));
    
  }
  /**
   * 
   * Given three strings, return the uppercase first char of the first input, lowercase first 4 chars of the second input, and last 3 digits of the last 
   * 
   * @param firstName The first string
   * @param LastName The second string
   * @param digits The third string
   * @return uppercase first char of the first input, lowercase first 4 chars of the second input, and last 3 digits of the last
   */
  public String createUserName(String firstName, String LastName, String digits){
    String firstBit = "";
    String SecondBit = "";
    String thirdBit = "";

    if (firstName == "" ||  LastName == "" || digits == "" || inputPassword.length() < 9){
      throw new IllegalArgumentException("Exception in thread main java.lang.IllegalArgumentException: " + firstName + LastName + digits + inputPassword);
    }

    firstBit += firstName.charAt(0);
    
    for (int i = 0; i < 4; i++){
      SecondBit += LastName.charAt(i);
    }

    for (int i = digits.length() - 4; i < digits.length(); i++){
      thirdBit += digits.charAt(i);
    }
    
    userName += firstBit;
    userName += SecondBit.toLowerCase(); 
    userName += thirdBit;

    return userName;
  }

  /**
   * 
   * When given a string, returns true or false if the string meets conditons
   * 
   * @param password The inputted String 
   * @return true or false if the string meets conditons
   */
  public boolean validatePassword(String password){
    
    int good = 0;

    if (password.length() >= 7){
      good++;
    }
    
    for (int i = 0; i < password.length(); i++){
      char letter;
      letter = password.charAt(i);
        if (!Character.isLetterOrDigit(letter)){
          return false;
        }
    }

    for (int i = 0; i < password.length(); i++){
      char letter;
      letter = password.charAt(i);
      if (Character.isUpperCase(letter)){
        good++;
      }
    }

    if (good >= 2){
      return true;
    }

    return false;

  }

}