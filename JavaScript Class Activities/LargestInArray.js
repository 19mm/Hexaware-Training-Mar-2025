function findLargestInArray(arr) {
    if (!Array.isArray(arr)) {
        return "Input must be an array.";
    }
    if (arr.length === 0) {
      return undefined;
    }
  
    const numbersOnly = arr.filter(item => typeof item === 'number');
    if (numbersOnly.length === 0) {
        return undefined; 
    }
    return Math.max(...numbersOnly);
  
    /* // Iterative alternative:
    if (!Array.isArray(arr) || arr.length === 0) return undefined;
    let largest = -Infinity; // Initialize with a very small number
    let foundNumber = false;
    for (let item of arr) {
        if (typeof item === 'number') {
            if (!foundNumber || item > largest) {
                largest = item;
            }
            foundNumber = true;
        }
    }
    return foundNumber ? largest : undefined;
    */
  }
  
  console.log("Largest in [1, 5, 2, 9, 3]:", findLargestInArray([1, 5, 2, 9, 3])); 
  console.log("Largest in [-10, -5, -20]:", findLargestInArray([-10, -5, -20])); 
  console.log("Largest in [100]:", findLargestInArray([100]));                 
  console.log("Largest in []:", findLargestInArray([]));                
  console.log("Largest in [1, 'a', 5]:", findLargestInArray([1, 'a', 5]));
  console.log("Largest in ['a', 'b']:", findLargestInArray(['a', 'b']));  