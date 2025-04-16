function checkOddEven(number) {
    if (typeof number !== 'number' || !Number.isInteger(number)) {
        return "Please provide an integer.";
    }
    if (number % 2 === 0) {
      console.log(number + " is even.");
      return "even"; 
    } else {
      console.log(number + " is odd.");
      return "odd"; 
    }
  }
  
  checkOddEven(4);
  checkOddEven(7);
  checkOddEven(0);
  checkOddEven(-2);
  checkOddEven(3.14);