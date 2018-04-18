package vc.thinker.b2b2c.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;

//@Controller
public class AddressJsonUtils {

	@Autowired
	private AreaServiceImpl areaServiceImpl;

	@Autowired
	private AreaDao areaDao;

//	@RequestMapping("addressJson")
//	@ResponseBody
	@SuppressWarnings({"rawtypes", "unchecked"})
	public String addressJson() {

		Collection<Area> list = areaDao.findAll();

		Collection<Area> listProvince = new ArrayList<Area>();
		Collection<Area> listCity = new ArrayList<Area>();
		Collection<Area> listCountry = new ArrayList<Area>();
		for (Area area : list) {
			if (area.getLevel() == 0) {
				listProvince.add(area);
			} else if (area.getLevel() == 1) {
				listCity.add(area);
			} else if (area.getLevel() == 2) {
				listCountry.add(area);
			}
		}

		List<Map> listM = new ArrayList<Map>();
		for (Area province : listProvince) {

			Map map = new LinkedHashMap<String, Object>();
			map.put("areaId", province.getId().toString());
			map.put("areaName", province.getAreaName());

			List<Map> listC = new ArrayList<Map>();
			for (Area c : listCity) {
				if (c.getParentId().equals(province.getId())) {
					Map mapc = new LinkedHashMap<String, Object>();
					mapc.put("areaId", c.getId().toString());
					mapc.put("areaName", c.getAreaName());

					List<Map> listCon = new ArrayList<Map>();
					for (Area con : listCountry) {
						if (con.getParentId().equals(c.getId())) {
							Map mapcon = new LinkedHashMap<String, Object>();
							mapcon.put("areaId", con.getId().toString());
							mapcon.put("areaName", con.getAreaName());
							listCon.add(mapcon);
						}
					}
					mapc.put("counties", listCon);
					listC.add(mapc);
				}
			}

			map.put("cities", listC);

			listM.add(map);
		}

		return Json.toJson(listM);

	}

//	public class AreaJsonObj{
//		
//		private String areaId;
//		private String areaName;
//		
//		public String getAreaId() {
//			return areaId;
//		}
//		public void setAreaId(String areaId) {
//			this.areaId = areaId;
//		}
//		public String getAreaName() {
//			return areaName;
//		}
//		public void setAreaName(String areaName) {
//			this.areaName = areaName;
//		}
//	}

}
