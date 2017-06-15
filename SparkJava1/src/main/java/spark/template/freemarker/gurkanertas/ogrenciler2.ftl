<html>

	<head>
	</head>
	
	<body>
	
		 <ul>
		 	  <!-- for(Ogrenci ogrenci : ogrenciler ) { -->
		 	  
			  <#list ogrenciler as ogrenci>
			  
			  	<li>${ogrenci.ogrenciBilgileriAl()}</li>
			  
			  </#list>
			  
			  <!-- } -->
			  
			  <a href="/ogrenciekle">Ogrenci Ekle</a>
		</ul>
	</body>
	
</html>