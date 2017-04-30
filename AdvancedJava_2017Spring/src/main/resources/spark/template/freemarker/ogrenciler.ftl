<!-- Freemarker template -->
<html>
	<head>
	</head>
	
	<body>
	    <h1>Ogrenci Listesi</h1>
	    <ul>
	    	<!-- http://freemarker.org/docs/ref_directive_list.html -->
	    	<#list ogrenciler as ogrenci>
	    	<li>${ogrenci.ogrenciBilgileriAl()}</li>
	    	</#list>
	    </ul>
	</body>
</html>