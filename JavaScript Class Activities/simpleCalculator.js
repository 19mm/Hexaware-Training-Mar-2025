function simpleCalculator(num1, num2, operator) {
    switch (operator) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        if (num2 === 0) {
          return "Error: Division by zero is not allowed.";
        }
        return num1 / num2;
      default:
        return "Error: Invalid operator. Please use +, -, *, or /.";
    }
  }
  
  console.log("10 + 5 =", simpleCalculator(10, 5, '+'));
  console.log("10 - 5 =", simpleCalculator(10, 5, '-'));
  console.log("10 * 5 =", simpleCalculator(10, 5, '*'));
  console.log("10 / 5 =", simpleCalculator(10, 5, '/'));
  console.log("10 / 0 =", simpleCalculator(10, 0, '/'));
  console.log("10 % 5 =", simpleCalculator(10, 5, '%')); 