<html>

	<head>
	</head>
	
	<body>
	<body bgcolor="#00ff7f">
		 <form method="POST" action="/ogrenciekle">
		 <label for="name">Ogrenci No</label>
		         <input type="text" id="ogrenciNo" name="ogrenciNo" />
		         <br/>
		 
				 <label for="name">Ad Soyad</label>
		         <input type="text" id="adSoyad" name="adSoyad" />
		         <br/>
		         
		         <label for="name">Ogrenci Tipi</label>
		         <select name="ogrenciTipi" id="ogrenciTipi">
                 <option value="Myo">Myo</option>
                 <option value="Lisans">Lisans</option>
                 <option value="Doktora">Doktora</option>
                 </select>
		        
		          <br>
		          
		         <label for="name">Bolum</label>
		         <input type="text" id="bolum" name="bolum" />
		         <br/>
		     
		         
		         <input type="submit" value="EKLE" />
		          <button onclick="window.location.href='/ogrenciler'">VAZGEÇ</button>
		 <form>
		 
	</body>
	
</html>