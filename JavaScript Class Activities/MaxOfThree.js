function findMaxOfThree(a, b, c) {
    
    if (a >= b && a >= c) {
        return a;
    } else if (b >= a && b >= c) {
        return b;
    } else {
        return c;
    }
}

console.log("Max of 10, 5, 15 is:", findMaxOfThree(10, 5, 15));
console.log("Max of -1, -5, 0 is:", findMaxOfThree(-1, -5, 0));