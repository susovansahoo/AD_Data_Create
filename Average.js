var mean = exports.mean = function(values) {
    var total = 0;
    for(var i=0; i<values.length; i++){
      total += values[i];
    }  
    return total/values.length;
};

function main() {
    console.log("The mean of 1 and 2 is ", mean([1,2]));
}
if (require.main === module) {
    main();
}