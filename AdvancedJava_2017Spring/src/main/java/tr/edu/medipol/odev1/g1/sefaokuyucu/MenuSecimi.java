package tr.edu.medipol.odev1.g1.sefaokuyucu;

public enum MenuSecimi {
	
	OGRENCI_EKLEME(1),
	OGRENCI_SILME(2),
	OGRENCI_LISTELE(3),
	CIKIS(0),
	BOS(-1);
	
	int menuId;
	
	MenuSecimi(int menuIdParam){
		this.menuId = menuIdParam;
	}
	
	public static MenuSecimi enumaCevir(int menuIdParam){
		for( MenuSecimi m : MenuSecimi.values()) {
			if (m.menuId == menuIdParam) {
				return m;
			}
		}
		return MenuSecimi.BOS;
	}

}
