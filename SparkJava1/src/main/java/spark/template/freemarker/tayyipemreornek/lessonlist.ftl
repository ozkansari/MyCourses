<!-- Freemarker template -->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Ders Listesi</title>
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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/studentlist">Ögrenci Yonetim Sistemi</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/studentlist">Ögrenci Listesi</a></li>
                <li><a href="/studentadd">Ögrenci Ekle</a></li>
                <li><a href="/studentdelete">Ögrenci Sil</a></li>
                <li class="active"><a href="/lessonlist">Ders Listesi</a></li>
                <li><a href="/lessonadd">Ders Ekle</a></li>
                <li><a href="/lessondelete">Ders Sil</a></li>
                <li><a href="/lessonstudent">Ders-Öğrenci Tablosu</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <center>
            <form action="/lessonshow" method="POST" accept-charset="utf-8">
                <h1>Medipol Üniversitesi Ders Listesi</h1>
                <table border="2" width="1000">
                    <td colspan="3"><a href="/lessonshow"><center><input type="submit" class="btn btn-default" value="Seçili Dersi Detaylı Görüntüle"/></center></a></td>
                    <tr>
                        <th width="200"><center> Ders Kodu </center></th>
                        <th width="600"><center> Ders Adı </center></th>
                        <th width="200"><center> İşlem </center></th>
                        <br>
                    </tr>
                    <#list lessons as lessons>
                        <tr>
                            <td><center>${lessons.lessonID()}</center></td>
                            <td><center>${lessons.lessonName()}</center></td>
                            <td><center><input type="radio" id="shows" name="shows" value="${lessons.lessonID()}"></center></td>
                        </tr>
                    </#list>
                    <td colspan="3"><a href="/lessonshow"><center><input type="submit" class="btn btn-default" value="Seçili Dersi Detaylı Görüntüle"/></center></a></td>
                </table>
            </form>
            </table>
        </center>
    </div>
    <footer class="footer">
        <p>&copy; Tayyip Emre ÖRNEK - teornek@gmail.com</p>
    </footer>
</div>
</body>
</html>