function reverseString(str) {
    if (typeof str !== 'string') {
      return "Input must be a string.";
    }
    return str.split('').reverse().join('');
  }
  
  console.log("Reverse of 'hello':", reverseString("hello"));           
  console.log("Reverse of 'JavaScript':", reverseString("JavaScript")); 
  console.log("Reverse of 'racecar':", reverseString("racecar"));       
  console.log("Reverse of '':", reverseString(""));                   