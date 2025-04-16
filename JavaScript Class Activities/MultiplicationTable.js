function printMultiplicationTable(number, limit = 10) { 
    if (typeof number !== 'number') {
        console.log("Please provide a valid number.");
        return;
    }
    console.log(`Multiplication table for ${number} (up to ${limit}):`);
    for (let i = 1; i <= limit; i++) {
      console.log(`${number} * ${i} = ${number * i}`);
    }
  }

printMultiplicationTable(5);
console.log("---"); 
printMultiplicationTable(7, 12); 