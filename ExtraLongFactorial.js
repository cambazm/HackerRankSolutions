'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the extraLongFactorials function below.
function extraLongFactorials(n) {
    var r = BigInt(1);
    //console.log(n);
    for(let i=n; i>0; i--) {
        //console.log(i);
        r = r * BigInt(i);
        //console.log(r);
    }
    var s = r.toString();
    console.log(s);
}

function main() {
    const n = parseInt(readLine(), 10);

    extraLongFactorials(n);
}
