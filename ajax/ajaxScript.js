window.onload = doNothing;
var xhttp;


function doNothing(params) {
    alert('ok the DOM has loaded');
}

function createXMLRequestObj() {
    alert("ok the DOM is loaded");
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = loadDoc;

    // xhr.open("GET", "athletes.xml", true);
    //xhr.send();;

    xhttp.open("GET", "athletes.xml", true);
    xhttp.send();
}



function loadDoc() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
        var xmlDoc = xhttp.responseXML;
        var sportList = xmlDoc.getElementsByTagName("sports");
        var html = "";
        var tabStr = "<table border='1'>";
        for (i = 0; i < sportList.length; i++) {
            tabStr += "<tr><td>" + sportList[i].getElementsByTagName("name")[0].childNodes[0].nodeValue + "</td><td>";
            tabStr += sportList[i].getElementsByTagName("country")[0].childNodes[0].nodeValue + "</td><td>";
            tabStr += sportList[i].getElementsByTagName("income")[0].childNodes[0].nodeValue + "</td></tr>";

                /*html +=
                xmlDoc.getElementsByTagName("date")[i].childNodes[0].nodeValue + "<br>" +
                xmlDoc.getElementsByTagName("home")[i].childNodes[0].nodeValue + "<br>" +
                xmlDoc.getElementsByTagName("away")[i].childNodes[0].nodeValue + "<br><br>";*/

            //res += "<div class =' '><a href='"+date+"','"+home+"','"+away+"'</a>";
        }
        tabStr += "</table border='1'> " 
            document.getElementById("demo").innerHTML = tabStr;
        }
    }
    /*
    function myFunction() {
        var i;
        var xmlDoc = xhttp.responseXML;
        var table = "<tr><th>Fixtures</th></tr>";

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var x = xmlDoc.getElementsByTagName("Rugby");
            for (i = 0; i < x.length; i++) {
                table += "<tr><td>" +
                    x[i].getElementsByTagName("match")[0].childNodes[0].nodeValue +
                    "</td><td>" +
                    x[i].getElementsByTagName("Team")[0].childNodes[0].nodeValue +
                    "</td></tr>" +
                    x[i].getElementsByTagName("kickOff")[0].childNodes[0].nodeValue +
                    "</td></tr>" +
                    x[i].getElementsByTagName("date")[0].childNodes[0].nodeValue +
                    "</td></tr>";
            }
            document.getElementById("demo").innerHTML = table;
        }
    }
    */