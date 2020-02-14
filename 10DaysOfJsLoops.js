'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
    const a = "a";
    const e = "e";
    const i = "i"; 
    const o = "o";
    const u = "u";

function vowelsAndConsonants(s) {

    var splitted = s.split('');
    var nonVowels = "";

    for(let c=0; c<splitted.length; c++) {
        if(isVowel(splitted[c])) {
            console.log(splitted[c]);
        }
        else {
            nonVowels = nonVowels + splitted[c];
        }
    }

    var nvSplitted = nonVowels.split('');
    for(let c=0; c<nvSplitted.length; c++) {
        console.log(nvSplitted[c]);
    }
}
function isVowel(l) {
    if(l == a || l == e || l == i || l == o || l == u) {
        return true;
    }
    else {
        return false;
    }
}
