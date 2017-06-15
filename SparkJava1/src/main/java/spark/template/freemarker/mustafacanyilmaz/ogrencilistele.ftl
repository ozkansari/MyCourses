<#import "template.ftl" as c/>
<@c.page title="Ogrenci Listele">
    <!-- custom page content -->

<div class="main">
<h1>Öğrenci Listele Burası </h1>

 <table style="width:500" table align="center" >
  
  <tr>
  	<th>Ogrenci Id</th>
    <th>Ad Soyad</th>
    <th>Bölüm</th> 
    <th>Ogrenci Tipi</th>
    <th>Ogrenci Detayı</th>
    <th>Ogrenci Sil</th>

    
    
  </tr>
  
		 <ul>
		 	  <!-- for(Ogrenci ogrenci : ogrenciler ) { -->
		 	  
			  <#list ogrenciler as ogrenci>
				<tr>
				<th><li>${ogrenci.ogrenciIdAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciAdAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciBolumAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciTipAl()}</li></th>
			  	<th>
				  	<form action="/ogrenciDetaySayfasi" method="POST">
				  	<input type="hidden" name="ogrenciNo" value="${ogrenci.ogrenciIdAl()}">
				  		<input type="submit" value="Ogrenci Detay">
				  	</form>
			  	</th>
			  	
			  	<th>
				  	<form action="/ogrencilistele" method="POST">
				  	<input type="hidden" name="ogrenciNo" value="${ogrenci.ogrenciIdAl()}">
				  		<input type="submit" value="Ogrenciyi Sil">
				  	</form>
			  	</th>
			  	
			  	
			  </tr>
			  </#list>
			  
			  
			  <!-- } -->
			 
		</ul>
  
</table>
	<center>
	 <form method="POST" action="/ogrencilistele2">
			<label for="name">Silinecek Ogrenci Id Giriniz</label>
			
		         <input type="text" id="silText" name="silText" />
		         <br/>
		       <input type="submit" value="Ogrenci Sil">
		         	
	</form>
	<a href="/ogrenciekle"><input type="submit" value="Ogrenci Ekle" name="ogrenciListeledenEkleye"></a>
	</center>

</div>


</@c.page>





