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
<nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Ogrenci Otomasyon Sistemi :)</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class=""><a href="/ogrenciler">Ogrenci Listesi</a></li>
                    <li class=""><a href="/ogrenciekle">Öğrenci Ekle</a></li>
                    <li class=""><a href="/dersler">Ders Listesi</a></li>
                    <li class=""><a href="/dersekle">Ders Ekle</a></li>
                    <li class="active"><a href="/dersogrenci">Ders Öğrenci İşlemleri</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <div class="container">
        <div class="jumbotron">
            <h1>Ogrenci Ekle</h1>
            <form class="form-inline" method="POST" action="/dersogrencipost">
                <div class="form-group">
                    <label for="name">Ders Id</label>
                    <input type="text" class="form-control" id="dersId" name="dersId">
                </div>

                <div class="form-group">
                    <label for="name">Öğrenci Id</label>
                    <input type="text" class="form-control" id="ogrenciNumara" name="ogrenciNumara">
                </div>

                <input type="submit" class="btn btn-default" value="Ekle" />
            </form>

            <a href="/ogrenciler">Vazgec</a>
        </div>

        <footer class="footer">
            <p>&copy; 2017 Ileri Java Medipol</p>
        </footer>

    </div>


</body>
</html>