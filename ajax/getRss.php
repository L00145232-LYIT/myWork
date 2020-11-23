<?php
	header("Expires: Mon, 17 Jul 2000 06:00:00 GMT");
	header("Cache-Control: no-cache");
	header("Content-type: text/xml");

	$url=$_GET["url"];
	echo file_get_contents($url);
?>
