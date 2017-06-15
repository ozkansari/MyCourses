<!-- Freemarker template -->
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    
	    <title>Ogrenci Ekle</title>
	    
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	
	
	<body>
		
		<!-- Static navbar -->
	    <nav class="navbar navbar-default navbar-static-top">
	      <div class="container">
	        <div class="navbar-header">
	          <a class="navbar-brand" href="#">Ogrencix</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	            <li><a href="/ogrenciler">Ogrenci Listesi</a></li>
	            <li class="active"><a href="/ogrenciekle">OgrenciEkle</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	    
	    <div class="container">
	    	<div class="jumbotron">
			    <h1>Ogrenci Ekle</h1>
			    <form class="form-inline" method="POST" action="/dersekle">
			     <div class="form-group">
		                <label for="name">Ders No</label>
		                <input type="text"
		                       class="form-control"
		                       id="dersNo"
		                       name="dersNo">
		            </div>
		            <div class="form-group">
		                <label for="name">Ders Adý</label>
		                <input type="text"
		                       class="form-control"
		                       id="dersAdi"
		                       name="dersAdi">
		            </div>
		            <div class="form-group">
		                <label for="name">Ders Tipi</label>
		                <input type="text"
		                       class="form-control"
		                       id="dersTipi"
		                       name="dersTipi">
		            </div>
		            
		            <input type="submit" class="btn btn-default" value="Ekle" />
		        </form>
		        
		        <a href="/dersler">Vazgec</a>
	        </div>
	        
	        <footer class="footer">
        		<p>&copy; 2017 Ileri Java Medipol</p>
      		</footer>
      	
	    </div>
	    
	    
	</body>
</html>