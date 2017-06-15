<html>

	<head>
	</head>
	
	<body>
	<body bgcolor="#00ff7f">
		 <form method="POST" action="/dersekle">
		         
		          <label for="name">Ders No</label>
		         <input type="text" id="dersNo" name="dersNo" />
		         <br/>
		         
		         
				 <label for="name">Dersin Adý</label>
		         <input type="text" id="dersAdi" name="dersAdi" />
		         <br/>
		         
		         <label for="name">Dersin Tipi</label>
		          <select name="dersTipi" id="dersTipi">
                 <option value="Secmeli">Seçmeli</option>
                 <option value="Zorunlu">Zorunlu</option>
               
                 </select>
		        
		        
		          <br>
		     
		         
		         <input type="submit" value="EKLE" />
		          <button onclick="window.location.href='/ogrenciler'">VAZGEÇ</button>
		 <form>
		 
	</body>
	
</html>