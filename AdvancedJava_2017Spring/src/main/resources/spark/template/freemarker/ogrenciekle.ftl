<!-- Freemarker template -->
<html>
	<head>
	</head>
	
	<body>
	    <h1>Ogrenci Listesi</h1>
	    <form class="form-inline" method="POST" action="/ogrenciekle">
            <div class="form-group">
                <label for="name">Ad Soyad</label>
                <input type="text"
                       class="form-control"
                       id="adSoyad"
                       name="adSoyad">
            </div>
            <div class="form-group">
                <label for="name">Ogrenci Tipi</label>
                <input type="text"
                       class="form-control"
                       id="ogrenciTipi"
                       name="ogrenciTipi">
            </div>
            <div class="form-group">
                <label for="name">Bolum</label>
                <input type="text"
                       class="form-control"
                       id="bolum"
                       name="bolum">
            </div>
            <input type="submit" class="btn btn-default" value="Ekle" />
        </form>
	</body>
</html>