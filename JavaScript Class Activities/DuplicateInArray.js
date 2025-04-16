function removeDuplicates(arr) {
    if (!Array.isArray(arr)) {
        return "Input must be an array.";
    }
    return [...new Set(arr)];
  
    // Alternative using Array.from()
    // return Array.from(new Set(arr));
  }
  
  console.log("Remove duplicates from [1, 2, 2, 3, 4, 4, 5]:", removeDuplicates([1, 2, 2, 3, 4, 4, 5]));
  console.log("Remove duplicates from ['a', 'b', 'a', 'c', 'b']:", removeDuplicates(['a', 'b', 'a', 'c', 'b']));
  console.log("Remove duplicates from [true, false, true]:", removeDuplicates([true, false, true]));
  console.log("Remove duplicates from []:", removeDuplicates([]));
  