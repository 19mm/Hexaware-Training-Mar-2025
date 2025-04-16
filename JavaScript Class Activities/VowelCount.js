function countVowels(str) {
    if (typeof str !== 'string') {
      return "Input must be a string.";
    }
    const vowels = "aeiouAEIOU";
    let vowelCount = 0;
  
    for (let char of str) {
      if (vowels.includes(char)) {
        vowelCount++;
      }
      /* // Alternative using array:
      if (vowels.includes(char.toLowerCase())) { // Convert char to lower case for case-insensitive check
          vowelCount++;
      }
      */
    }
  
    return vowelCount;
  }
  
  console.log("Vowels in 'Hello World':", countVowels("Hello World"));  
  console.log("Vowels in 'JavaScript is FUN':", countVowels("JavaScript is FUN")); 
  console.log("Vowels in 'Rhythm':", countVowels("Rhythm"));         
  console.log("Vowels in '':", countVowels(""));                   