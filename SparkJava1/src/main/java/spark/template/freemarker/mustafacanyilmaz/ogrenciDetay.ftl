<#import "template.ftl" as c/>
<@c.page title="Ogrenci Detay">
    <!-- custom page content -->


<div class="main">

<h1> Öğrenci Detay Sayfasındasınız </h1>


 <table style="width:500" table align="center" >
  
  <tr>
  	<th>Ogrenci Id</th>
    <th>Ad Soyad</th>
    <th>Ogrenci Yas</th> 
    <th>Ogrenci Ders 1</th>
    <th>Ogrenci Ders 2</th>
    <th>Ogrenci Ders Kayıt</th>
    
  </tr>
  
		 <ul>
		 
				<tr>
				<th><li>${ogrenci.ogrenciIdAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciAdAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciYasAl()}</li></th>
			  	<th><li>${ogrenci.ogrenciDers1Al()}</li></th>
			  	<th><li>${ogrenci.ogrenciDers2Al()}</li></th>
			  	<th><input type="checkbox" name="checkbox" id="checkbox" checked>
			  	
			  </tr>
			 
		
			 
		</ul>
  
</table>

<center><a href="/ogrencilistele">Geri Don</a></center>

</div>



</@c.page>






