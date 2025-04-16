function factorial(n) {
    if (typeof n !== 'number' || !Number.isInteger(n)) {
      return "Input must be an integer.";
    }
    if (n < 0) {
      return "Factorial is not defined for negative numbers.";
    }
    if (n === 0 || n === 1) {
      return 1; 
    }
  
    let result = 1;
    for (let i = 2; i <= n; i++) {
      result *= i; 
    }
    return result;
  
    /* // Recursive alternative:
    if (n < 0) return "Factorial is not defined for negative numbers.";
    if (n === 0 || n === 1) return 1;
    return n * factorial(n - 1);
    */
  }
  
  console.log("Factorial of 5:", factorial(5));  
  console.log("Factorial of 0:", factorial(0));   
  console.log("Factorial of 1:", factorial(1));   
  console.log("Factorial of -3:", factorial(-3)); 