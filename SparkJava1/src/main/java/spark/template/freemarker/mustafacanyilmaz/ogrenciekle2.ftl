<#import "template.ftl" as c/>
<@c.page title="Ogrenci Ekle">
    <!-- custom page content -->
		

<div class="main">

<p>
<h1> Gerekli Alanları Eksiksiz Doldurunuz !  </h1>
</p>

		 <form method="POST" action="/ogrenciekle">
		 
		 		 <label for="name">Ogrenci Id</label>
		         <input type="number" min="1" max="9999999" id="ogrenciId" name="ogrenciId" required/>
		         <br/>
		 
				 <label for="name">Ad Soyad</label>
		         <input type="text" id="adSoyad" name="adSoyad" required  />
		         <br/>

		         <label for="name">Ogrenci Tipi </label><select id="ogrenciTipi" name="ogrenciTipi">
		         <option id="lisansOgrencisi" name="lisansOgrencisi">Lisans</option>
		         <option id="yuksekLisans" name="yuksekLisans">YuksekLisans</option>
		         <option id="doktora" name="doktora">Doktora</option>
		         <option id="prof" name="prof">Prof</option>
		         </select><br>
		         
		         <label for="name">Bolum</label>
		         <input type="text" id="bolum" name="bolum" required />
		         <br/>
		         
		         <h3>Ders Ekleme</h3>
		         
		           <label for="name">Ogrenci Yas</label>
		           <select id="ogrenciYas" name="ogrenciYas">
		           <#assign x=100>
					<#list 18..x as i>
					  <option value="${i}">${i}</option>
					</#list>
		           
		           </select><br>
		           
		           
		        
		  
		         <label for="name">Ogrenci Ders 1</label>
		         <input type="text" id="ogrenciDers1" name="ogrenciDers1" required />
		         <br/>
		         
		         <label for="name">Ogrenci Ders 2</label>
		         <input type="text" id="ogrenciDers2" name="ogrenciDers2" required />
		         <br/>
		         
		         <input type="submit" value="Ekle" />
		         <a href="/ogrencilistele">Vazgec</a>
		         
		         
		 <form>
		 
		 </div>
		 </@c.page>
		 
		 
		 
		