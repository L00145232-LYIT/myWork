// JavaScript Document
window.onload = selectNumber;

var maxNumber = 3;
var xmlhttp;
var url = null;


//  function: 	selectNumber
// 							Determines the number news items to display
//  						Initial set to 3 
function selectNumber() {
	//var i = 0;
	for (var i = 0; i < 8; i++) {
		document.getElementById("number").options[i] = new Option(i + 2, i);
		if (i == (maxNumber - 3)) {
			document.getElementById("number").options[i].selected = true;
		}
	}
}

// function: 	selectChange
//						When the option is changed we retrieve the rss item number 
//						with the new parameter
function selectChange() {
	var temp = document.getElementById("number").value;
	maxNumber = parseInt(temp) + 2;
	startAjaxObj();
}


//Function: ajaxFunctionPage
// 					get the url in relation to the parameter and launch Ajax object
function ajaxFunctionPage(urlParam) {
	if (urlParam == "BBC News") {
		url = "http://newsrss.bbc.co.uk/rss/newsonline_world_edition/front_page/rss.xml";
	} else if (urlParam == "RTE News") {
		url = "https://www.rte.ie/radio1/podcast/podcast_seanorourke.xml";
	} else {
		url = "http://feeds.timesonline.co.uk/c/32313/f/440158/index.rss";
	}
	startAjaxObj();
}

//Function: startAjaxObj
//      Stops the  timer and launch new AJAX obj with timer retrieve the rss
//			when the state changes, call the method stateChanged
//			call this method, or every 3 mins if the page is not changed by the user
function startAjaxObj() {
	//clearTimeout(timerGlobal);
	alert("ok timer on");
	if (url == null) { return;	}

	xmlhttp = new XMLHttpRequest();
	if (xmlhttp == null) {
		alert("Browser does not support AJAX");
		return;
	}

	xmlhttp.onreadystatechange = stateChanged;
	var urlSend = "getRss.php?url=" + url;

	xmlhttp.open("GET", urlSend, true);
	xmlhttp.send(null);
	setTimeout( startAjaxObj,  60 * 5000);
}

//Function:  stateChanged
//			when the state is 4 and the response is 200
// 			we get the data and display on the page
function stateChanged() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var res = "";

		var node = xmlhttp.responseXML.documentElement;

		var channel = node.getElementsByTagName('channel')[0];
		var title_channel = channel.getElementsByTagName("title")[0].childNodes[0].nodeValue;
		var link_channel = channel.getElementsByTagName("link")[0].childNodes[0].nodeValue;
		var description_channel = channel.getElementsByTagName("description")[0].childNodes[0].nodeValue;

		res = `<div class='channel'> ${title_channel}  -- 
		<a href='${link_channel}'> ${description_channel}</div><hr><br> `;
		
		var nodeItem = node.getElementsByTagName('item');

		// check that items is greater than maxnumber  
		(nodeItem.length < maxNumber) ? maxNumber = nodeItem.length: maxNumber ;

		var itemStr ='';
		for (i = 0; i < maxNumber; i++) {
			var title = nodeItem[i].getElementsByTagName('title')[0].childNodes[0].nodeValue;
			var date = nodeItem[i].getElementsByTagName('pubDate')[0].childNodes[0].nodeValue;
			var desc = nodeItem[i].getElementsByTagName('description')[0].childNodes[0].nodeValue;
			var links = nodeItem[i].getElementsByTagName('link')[0].childNodes[0].nodeValue;
			//var mod = removeImage(desc);

			res += `Link:<div class='item'><a href='${links}'>${title} </a><br> 
			Description : ${desc} <br> ${date}</div>`;

			// res = res + "<div class='space'><a href='" + links + "'>" + title + "</a>";
			// res = res + "<div class='desc' id='" + i + "'><br/>" + desc + "</div></div><br/>";
			if (i != maxNumber - 1)
			res = res + "<br>";
		}

		//res = res + "</div><div class='downRss_bottom'></div>";

		document.getElementById("rss_feed").innerHTML = res ;
	}
}