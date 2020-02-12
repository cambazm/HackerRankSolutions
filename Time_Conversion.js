'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(str => str.trim());

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the timeConversion function below.
 */
function timeConversion(s) {
    var ampm = s.substring(8,10);
    //console.log(ampm);
    var hour = s.substring(0,2);
    //console.log(hour);
    if(ampm == "PM") {
        let h = parseInt(hour);
        if(h!=12)
            h = h+12;
        if(h==24)
            return "00" + s.substring(2,8);
        else
            return h + s.substring(2,8);
    }
    else {
        let h = parseInt(hour);
        if(h==12)
            return "00" + s.substring(2,8);
        else
            return hour + s.substring(2,8);
    }
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    let result = timeConversion(s);

    ws.write(result + "\n");

    ws.end();
}
