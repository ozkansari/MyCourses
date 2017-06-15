<html>

	<head>
	<h1 align="center">ANA SAYFA</h1>
	
	</head>
	
	<body>
	
<body bgcolor="#79cdcd">
	<table border="1" ALIGN="center">
<tr>
<th>Ogrenci No - Adý Soyadý - Bölümü - Tipi</th>


</tr>
<tr>
<td><!-- for(Ogrenci ogrenci : ogrenciler ) { -->
		 	  
			  <#list ogrenciler as adSoyad>
			  
			  	<li>${adSoyad.ogrenciBilgileriAl()}</li>
			  	
			 
			  
			  </#list>
			  
			  
			  <!-- } --></a></td>
</table>
	
			  <table border="3" ALIGN="center">
<tr>
<th>SEÇENEKLER</th>


</tr>
<tr>
<td>
 <button  onclick="window.location.href='/ogrenciekle'">OGRENCÝ EKLE</button>
			 <button onclick="window.location.href='/ogrencisil'">OGRENCÝ SÝL</button>
			  <button onclick="window.location.href='/dersler'">DERSLERÝ GÖRÜNTÜLE</button>
</table>
			
			 
	</body>
	
	
</html>