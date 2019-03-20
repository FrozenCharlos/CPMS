//全局工具
var utils = {
	/*
	 * 时间转换方法
	 */
	formatDate: function(date, retV){
		if (retV.indexOf("MM") != -1) {
			var m = date.getMonth() + 1;
			m = m < 10 ? "0" + m : m;
			retV = retV.replace(/MM/g, m);
		}
		retV = retV.toLowerCase();
		// parse year

		if (retV.indexOf("yyyy") != -1) {
			retV = retV.replace(/yyyy/g, date.getFullYear());
		} else if (retV.indexOf("yy") != -1) {
			var year4 = date.getFullYear();
			var year2 = year4.toString().substring(2);
			retV = retV.replace(/yy/g, year2);
		}
		// parse day
		if (retV.indexOf("dd") != -1) {
			var d = date.getDate();
			d = d < 10 ? "0" + d : d;
			retV = retV.replace(/dd/g, d);
		}
		// parse hours
		if (retV.indexOf("hh") != -1) {
			var h = date.getHours();
			h = h < 10 ? "0" + h : h;
			retV = retV.replace(/hh/g, h);
		}
		// parse minute
		if (retV.indexOf("mm") != -1) {
			var mm = date.getMinutes();
			mm = mm < 10 ? "0" + mm : mm;
			retV = retV.replace(/mm/g, mm);
		}
		// parse second
		if (retV.indexOf("ss") != -1) {
			var s = date.getSeconds();
			s = s < 10 ? "0" + s : s;
			retV = retV.replace(/ss/g, s);
		}
		// week
		if (retV.indexOf("w") != -1) {
			retV = retV.replace(/w/g, "0");
		}
		return retV;
	}
}