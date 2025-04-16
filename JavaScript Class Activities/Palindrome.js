function isPalindrome(str) {
    if (typeof str !== 'string') {
      return false; 
    }
    const reversedStr = str.split('').reverse().join('');
  
    return str === reversedStr;
  
    /* 
     const cleanedStr = str.toLowerCase().replace(/[^a-z0-9]/g, '');
     const reversedCleanedStr = cleanedStr.split('').reverse().join('');
     return cleanedStr === reversedCleanedStr;
    */
  }
  
  console.log("Is 'madam' a palindrome?", isPalindrome("madam"));     // Output: true
  console.log("Is 'racecar' a palindrome?", isPalindrome("racecar")); // Output: true
  console.log("Is 'hello' a palindrome?", isPalindrome("hello"));     // Output: false
  console.log("Is 'A man a plan a canal Panama' a palindrome?", isPalindrome("A man a plan a canal Panama")); 