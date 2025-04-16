function isPrime(num) {
    if (typeof num !== 'number' || !Number.isInteger(num)) {
      return false; 
    }
    if (num <= 1) {
      return false; 
    }
    if (num <= 3) {
      return true; 
    }
    if (num % 2 === 0 || num % 3 === 0) {
      return false; 
    }
  
    for (let i = 5; i * i <= num; i = i + 6) {
      if (num % i === 0 || num % (i + 2) === 0) {
        return false;
      }
    }
  
    return true;
  }
  
  console.log("Is 2 prime?", isPrime(2));     
  console.log("Is 3 prime?", isPrime(3));     
  console.log("Is 4 prime?", isPrime(4));     
  console.log("Is 17 prime?", isPrime(17));   
  console.log("Is 25 prime?", isPrime(25));   
  console.log("Is 97 prime?", isPrime(97));   
  console.log("Is 1 prime?", isPrime(1));     
  console.log("Is 0 prime?", isPrime(0));     
  console.log("Is -5 prime?", isPrime(-5));  