function calculateStuff(val1, val2){
    if (val1 == val2)
        console.log("you have won 1 million");
    else
        console.log("try again");

    var students = ["John", "jane", "peter", "smith"];

    console.log("for loop to loop through the array");
    var oneline = '';
    for (var idx = 0; idx< students.length; idx++)
        oneline += students[idx] + " ";

    console.log(oneline);

    console.log("using forreach to loop through the array");
    students.forEach(function(val){
        console.log(val);
    });

    console.log("using while loop");
    var idx = 0;
    while(idx<students.length){
        console.log(students[idx]);
        idx++;

    }
}

calculateStuff(23,45);

var organization = {
    data: [{
        name: 'EGERTON',
        address: 'NJORO'
    },{
        name: 'MOI',
        address: 'ELDORET'
    },{
        name: 'NAIROBI',
        address: 'NAIROBI'
    },{
        name: 'KENYATTA UNI',
        address: 'NAIROBI'
    },{
        name: 'JKUAT UNI',
        address: 'JUJA/THIKA'
    },{
        name: 'DEDAN KIMATHI',
        address: 'NYERI'
    }],
    showTable: function(){
        var tableContent = '<table id="customers">'
        + '<tr>'
            + '<th>Name</th>'
            + '<th>Address</th>'
        + '</tr>';

       /* this.data.forEach(col => {
            tableContent += '<tr><td>' + col.name + '</td><td>' + col.address + '</td></tr>';
        })*/

        for (var idx = 0; idx<this.data.length; idx++)
            tableContent += '<tr><td>' + this.data[idx].name + '</td><td>' + this.data[idx].address + '</td></tr>';

        tableContent += '</table>';

        document.getElementById('content').innerHTML = tableContent;
    }
};

organization.showTable();