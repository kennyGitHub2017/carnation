package com.sinco.carnation.user.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.user.service.AlbumService;

/**
 * 
 * <p>
 * Title: ImageTools.java
 * </p>
 * 
 * <p>
 * Description: 图片工具类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-10-28
 * 
 * @version 1.0.1
 */
@Component
public class ImageTools {
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private AlbumService albumService;

	public Accessory queryImg(Object id) {
		if (id != null && !id.equals("")) {
			Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(id));
			return img;
		}
		return null;
	}

	public List<Accessory> queryImgs(String ids) {
		List<Accessory> list = new ArrayList<Accessory>();
		if (ids != null && !ids.equals("")) {
			for (String str : ids.split(",")) {
				if (str != null && !str.equals("")) {
					Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(str));
					list.add(img);
				}
			}
		}
		return list;
	}

	/**
	 * 随机数赋值给id 下面queryRemoteImgs按时间赋值ID，会出现一样的值
	 * 
	 * @param urls
	 * @return
	 */
	public List<Accessory> queryRemoteImgs2(String urls) {
		List<Accessory> list = new ArrayList<Accessory>();
		if (StringUtils.isNotBlank(urls)) {
			String[] arr = urls.split(";");
			for (int i = 0; i < arr.length; i++) {
				if (StringUtils.isNotBlank(arr[i])) {
					Accessory img = new Accessory();
					img.setPath(arr[i]);
					img.setId(Long.parseLong(CommUtil.randomInt(10)));
					list.add(img);
				}
			}
		}
		return list;
	}

	public List<Accessory> queryRemoteImgs(String urls) {
		List<Accessory> list = new ArrayList<Accessory>();
		if (StringUtils.isNotBlank(urls)) {
			String[] arr = urls.split(";");
			for (int i = 0; i < arr.length; i++) {
				if (StringUtils.isNotBlank(arr[i])) {
					Accessory img = new Accessory();
					img.setPath(arr[i]);
					img.setId(new Date().getTime() + i * 1000);
					list.add(img);
				}
			}
		}
		return list;
	}

	public List<String> queryImg(String imgs) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotBlank(imgs)) {
			for (String img : imgs.split("\\|")) {
				list.add(img);
			}
		}
		return list;
	}

	// public List<Accessory> queryAlbumPhotos(String album_id) {
	// List<Accessory> list = new ArrayList<Accessory>();
	// Album album = this.albumService
	// .getObjById(CommUtil.null2Long(album_id));
	// if (album != null) {
	// Map params = new HashMap();
	// params.put("album_id", CommUtil.null2Long(album_id));
	// list = this.accessoryService
	// .query("select obj from Accessory obj where obj.album.id=:album_id",
	// params, -1, -1);
	// }
	// return list;
	// }

	// public int queryAlbumPhotosSize(String album_id) {
	// int size = 0;
	// List<Accessory> list = new ArrayList<Accessory>();
	// Album album = this.albumService
	// .getObjById(CommUtil.null2Long(album_id));
	// if (album != null) {
	// Map params = new HashMap();
	// params.put("album_id", CommUtil.null2Long(album_id));
	// list = this.accessoryService
	// .query("select obj.id from Accessory obj where obj.album.id=:album_id",
	// params, -1, -1);
	// size = list.size();
	// }
	// return size;
	// }
}
