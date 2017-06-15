Ders bilgileri </br >
<li>${ders.dersBilgileriAl()}</li>

</br>
<h2>Öğrenci Listesi öğrenciler</h2>

   <form class="form-inline" method="POST" action="/derseogrenciekle">
<table>
     <tr>
         <td></td>
         <td>  ad soyad numara</td>
     </tr>
      <#list dersiAlanogrenciListesi as ogrenci>
     <tr>
        <td><input name="checklistesi" type="checkbox" ${ogrenci.getCheckDurumu()}/>
          <td>${ogrenci.ogrenciBilgi()} </td>
     </tr>
      </#list>
 </table>
  <input type="submit" class="btn btn-default" value="Kaydet" />

  </form>


