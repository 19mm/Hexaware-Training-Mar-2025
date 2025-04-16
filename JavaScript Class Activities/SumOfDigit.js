function sumDigits(number) {
    if (typeof number !== 'number') {
        return "Input must be a number.";
    }
    const numStr = Math.abs(number).toString();
    let sum = 0;
  
    for (let digitChar of numStr) {
      if (!isNaN(parseInt(digitChar))) {
          sum += parseInt(digitChar); 
      }
    }
    return sum;
  
    /* // Alternative using modulo and division (works only for non-negative integers):
    if (number < 0) number = Math.abs(number); // Handle negative
    let sum = 0;
    while (number > 0) {
        sum += number % 10; // Add the last digit
        number = Math.floor(number / 10); // Remove the last digit
    }
    return sum;
    */
  }
  
  console.log("Sum of digits of 123:", sumDigits(123));    
  console.log("Sum of digits of 9876:", sumDigits(9876));  
  console.log("Sum of digits of 5:", sumDigits(5));       
  console.log("Sum of digits of -451:", sumDigits(-451)); 
  console.log("Sum of digits of 100:", sumDigits(100));   