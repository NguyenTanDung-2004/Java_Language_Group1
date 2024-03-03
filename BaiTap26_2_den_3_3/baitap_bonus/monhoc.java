package oop;

import java.util.HashMap;
import java.util.Iterator;

public class monhoc {
	public static HashMap<String, Integer> monhoc_soluong; // Map này có tác dụng là lưu lại những môn học trong trường và số lượng sinh viên đăng kí.
	public monhoc() {
		monhoc_soluong = new HashMap<>();
	}
	public static void tang_sl_dk(String key) {
		int sl = monhoc_soluong.get(key);
		monhoc_soluong.put(key, sl + 1);
	}
	public static String monhoc_sv_dk_nhieunhat() {
		Iterator<HashMap.Entry<String, Integer> > iterator = monhoc_soluong.entrySet().iterator();
		int Flag = 0;
		String MonHoc = null;
		while(true)
		{
			if(iterator.hasNext() == false)
			{
				break;
			}
			HashMap.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() > Flag) {
				Flag = entry.getValue();
				MonHoc = entry.getKey();
			}
		}
		return MonHoc;
	}
	public static int so_sinhvien_cua_monhoc_dk_nhieunhat() {
		return monhoc_soluong.get(monhoc.monhoc_sv_dk_nhieunhat());
	}
}
