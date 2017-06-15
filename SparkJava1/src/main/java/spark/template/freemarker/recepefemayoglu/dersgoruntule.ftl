<div class="row">
    <h1>Ders bilgileri</h1> <br />
    <p>Ders Adı:${ders.getAd()}</p><br />
    <p>Akts:${ders.getAkts()}</p><br />
    <p>Id:${ders.getId()}</p><br />
</div>
<br/>
<h1> Dersi Alan Öğrenciler </h1>



            <table>
                <thead>
                    <tr>
                        <th>Ad</th>
                        <th>Soyad</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#list ogrenciler as ogrenci>
                        <tr>
                            <td> ${ogrenci.getAd()}</td>
                            <td> ${ogrenci.getSoyad()}</td>
                            <td><a href='/ogrencigoruntule/${ogrenci.getNumara()}'>Görüntüle</a>  <a href='/ogrencisil/${ogrenci.getNumara()}'>Sil</a> </td>
                        </tr>
                    </#list>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Ad</th>
                        <th>Soyad</th>
                        <th></th>
                    </tr>
                </tfoot>
            </table>