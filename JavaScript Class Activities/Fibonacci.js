function generateFibonacci(n) {
    if (typeof n !== 'number' || !Number.isInteger(n) || n < 0) {
        return "Please provide a non-negative integer.";
    }
    if (n === 0) {
      return []; 
    }
    if (n === 1) {
      return [0];
    }
  
    let fibSeries = [0, 1]; 

    for (let i = 2; i < n; i++) {
      let nextFib = fibSeries[i - 1] + fibSeries[i - 2];
      fibSeries.push(nextFib);
    }
  
    return fibSeries;
  }
  

  console.log("First 10 Fibonacci numbers:", generateFibonacci(10));
  console.log("First 1 Fibonacci number:", generateFibonacci(1));  
  console.log("First 2 Fibonacci numbers:", generateFibonacci(2)); 
  console.log("First 0 Fibonacci numbers:", generateFibonacci(0)); 