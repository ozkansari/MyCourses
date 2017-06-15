<div class="row">
    <h1>Öğrenci bilgileri </h1><br/>
    <p>Öğrenci Adı:${ogrenci.getAd()}</p><br/>
    <p>Öğrenci Soyad:${ogrenci.getSoyad()}</p><br/>
    <p>Öğrenci Numara:${ogrenci.getNumara()}</p><br/>
    <p>Öğrenci Tipi:${ogrenci.getOgrenciTipiId()}</p><br/>
</div>
<h1>Öğrencinin Aldığı Dersler</h1> <br/>

    <div class="container">
        <div class="jumbotron">
            <h1>Ders Listesi</h1>
            <table>
                <thead>
                    <tr>
                        <th>Ad</th>
                        <th>Akts</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#list dersler as ders>
                        <tr>
                            <td> ${ders.getAd()}</td>
                            <td> ${ders.getAkts()}</td>
                            <td><a href='/dersgoruntule/${ders.getId()}'>Görüntüle</a>  <a href='/derssil/${ders.getId()}'>Sil</a> </td>
                        </tr>
                    </#list>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Ad</th>
                        <th>Akts</th>
                        <th></th>
                    </tr>
                </tfoot>
            </table>
            <a href="/dersekle">Ders Ekle</a>
        </div>




