package com.sinco.carnation.resource.web.util;

import org.nlpcn.commons.lang.util.StringUtil;

/**
 * 心率结论工具类
 * 
 * @author yuanming
 * 
 */
public class AnalysisCodeUtil {

	public static String analysisMessage(String analysisCode) {
		if (StringUtil.isBlank(analysisCode)) {
			return "";
		}
		String[] nums = analysisCode.split(";");
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			if ("200".equals(nums[i]) || "0".equals(nums[i]) || "1".equals(nums[i])) {
				continue;
			}
			String message = getMessage(Integer.parseInt(nums[i]));
			if (result.length() != 0) {
				result.append(",");
			}
			result.append(message);
		}
		return result.toString();
	}

	public static String getMessage(Integer num) {
		String mesage = null;
		switch (num) {
			case 0:
				mesage = "";
				break;
			case 1:
				mesage = "";
				break;
			case 2:
				mesage = "波形记录不良";
				break;
			case 3:
				mesage = "可能右位心";
				break;
			case 4:
				mesage = "可能左右肢电极接反";
				break;
			case 5:
				mesage = "顺钟向转位";
				break;
			case 6:
				mesage = "逆钟向转位";
				break;
			case 7:
				mesage = "明显的顺钟向转位";
				break;
			case 8:
				mesage = "明显的逆钟向转位";
				break;
			case 9:
				mesage = "低电压（肢体导联）";
				break;
			case 10:
				mesage = "低电压（胸导联）";
				break;
			case 11:
				mesage = "低电压（全部导联）";
				break;
			case 12:
				mesage = "QTc 延长";
				break;
			case 13:
				mesage = "QTc 缩短";
				break;
			case 14:
				mesage = "无法确定的心电轴";
				break;
			case 15:
				mesage = "轻微电轴左偏";
				break;
			case 16:
				mesage = "心电轴右偏";
				break;
			case 17:
				mesage = "明显的心电轴右偏";
				break;
			case 18:
				mesage = "心电轴左偏";
				break;
			case 19:
				mesage = "明显的心电轴左偏";
				break;
			case 20:
				mesage = "电轴极度偏移(3S 型)";
				break;
			case 21:
				mesage = "TV1 直立(TV1>TV5)";
				break;
			case 22:
				mesage = "左心室高电压";
				break;
			case 23:
				mesage = "右心室高电压";
				break;
			case 24:
				mesage = "左心室肥大";
				break;
			case 25:
				mesage = "怀疑左心室肥大";
				break;
			case 26:
				mesage = "怀疑左心室肥大(此年龄正常)";
				break;
			case 27:
				mesage = "左心室肥大-I,aVL 高电压";
				break;
			case 28:
				mesage = "右心室肥大";
				break;
			case 29:
				mesage = "怀疑右心室肥大";
				break;
			case 30:
				mesage = "左、右心室肥大";
				break;
			case 31:
				mesage = "左心房扩大";
				break;
			case 32:
				mesage = "右心房扩大";
				break;
			case 33:
				mesage = "左、右心房扩大";
				break;
			case 34:
				mesage = "P-R 缩短";
				break;
			case 35:
				mesage = "怀疑 WPW 综合症";
				break;
			case 36:
				mesage = "WPW 综合症";
				break;
			case 37:
				mesage = "WPW 综合症（A 型）";
				break;
			case 38:
				mesage = "WPW 综合症（B 型）";
				break;
			case 39:
				mesage = "WPW 综合症（C 型）";
				break;
			case 40:
				mesage = "P-R 延长";
				break;
			case 41:
				mesage = "Ⅰ度房室传导阻滞";
				break;
			case 42:
				mesage = "Ⅱ度Ⅱ型房室传导阻滞";
				break;
			case 43:
				mesage = "Ⅱ度Ⅰ型房室传导阻滞";
				break;
			case 44:
				mesage = "Ⅱ度房室传导阻滞(2:1)";
				break;
			case 45:
				mesage = "Ⅲ度完全性房室传导阻滞";
				break;
			case 46:
				mesage = "心房内传导阻滞";
				break;
			case 47:
				mesage = "人工心脏起搏器心律";
				break;
			case 48:
				mesage = "人工心脏起搏器心律(心房)";
				break;
			case 49:
				mesage = "人工心脏起搏器心律(心室)";
				break;
			case 50:
				mesage = "V1/V2 RSR'型，右室传导延迟";
				break;
			case 51:
				mesage = "心室内传导阻滞";
				break;
			case 52:
				mesage = "不完全右束支传导阻滞";
				break;
			case 53:
				mesage = "完全性右束支传导阻滞";
				break;
			case 54:
				mesage = "不完全左束支传导阻滞";
				break;
			case 55:
				mesage = "完全性左束支传导阻滞";
				break;
			case 56:
				mesage = "左前束支传导阻滞";
				break;
			case 57:
				mesage = "左后束支传导阻滞";
				break;
			case 58:
				mesage = "两束支传导阻滞";
				break;
			case 59:
				mesage = "三束支传导阻滞";
				break;
			case 60:
				mesage = "梗死周围传导阻滞";
				break;
			case 61:
				mesage = "T 波改变（T 波低平）";
				break;
			case 62:
				mesage = "T 波改变（T 波倒置）";
				break;
			case 63:
				mesage = "T 波改变（T 波高耸）";
				break;
			case 64:
				mesage = "ST 上升";
				break;
			case 65:
				mesage = "ST 下降";
				break;
			case 66:
				mesage = "ST 下降（轻度）";
				break;
			case 67:
				mesage = "ST 下降（洋地黄影响可能）";
				break;
			case 68:
				mesage = "ST-T 改变（洋地黄影响可能）";
				break;
			case 69:
				mesage = "非特异的 T 改变";
				break;
			case 70:
				mesage = "非特异的 ST 改变";
				break;
			case 71:
				mesage = "非特异的 ST-T 改变";
				break;
			case 72:
				mesage = "ST-T 改变";
				break;
			case 73:
				mesage = "ST-T 改变（前壁心肌缺血可能）";
				break;
			case 74:
				mesage = "ST-T 改变（前侧壁心肌缺血可能）";
				break;
			case 75:
				mesage = "ST-T 改变（侧壁心肌缺血可能）";
				break;
			case 76:
				mesage = "ST-T 改变（下壁心肌缺血可能）";
				break;
			case 77:
				mesage = "T 波改变";
				break;
			case 78:
				mesage = "T 波改变（前壁心肌缺血可能）";
				break;
			case 79:
				mesage = "T 波改变（前侧壁心肌缺血可能）";
				break;
			case 80:
				mesage = "T 波改变（侧壁心肌缺血可能）";
				break;
			case 81:
				mesage = "T 波改变（下壁心肌缺血可能）";
				break;
			case 82:
				mesage = "R 峰减高";
				break;
			case 83:
				mesage = "异常 Q 波";
				break;
			case 84:
				mesage = "心内膜下梗死(可能)";
				break;
			case 85:
				mesage = "前壁心肌梗死可能";
				break;
			case 86:
				mesage = "前壁心肌梗死";
				break;
			case 87:
				mesage = "前壁心肌梗死（急性）";
				break;
			case 88:
				mesage = "前壁心肌梗死（近期内）";
				break;
			case 89:
				mesage = "前壁心肌梗死（陈旧性）";
				break;
			case 90:
				mesage = "侧壁心肌梗死可能";
				break;
			case 91:
				mesage = "侧壁心肌梗死";
				break;
			case 92:
				mesage = "侧壁心肌梗死（急性）";
				break;
			case 93:
				mesage = "侧壁心肌梗死（近期内）";
				break;
			case 94:
				mesage = "侧壁心肌梗死（陈旧性）";
				break;
			case 95:
				mesage = "下壁心肌梗死可能";
				break;
			case 96:
				mesage = "下壁心肌梗死";
				break;
			case 97:
				mesage = "下壁心肌梗死（急性）";
				break;
			case 98:
				mesage = "下壁心肌梗死（近期内）";
				break;
			case 99:
				mesage = "下壁心肌梗死（陈旧性）";
				break;
			case 100:
				mesage = "前壁中隔心肌梗死可能";
				break;
			case 101:
				mesage = "前壁中隔心肌梗死";
				break;
			case 102:
				mesage = "前壁中隔心肌梗死（急性）";
				break;
			case 103:
				mesage = "前壁中隔心肌梗死（近期内）";
				break;
			case 104:
				mesage = "前壁中隔心肌梗死（陈旧性）";
				break;
			case 105:
				mesage = "广泛前壁心肌梗死可能";
				break;
			case 106:
				mesage = "广泛前壁心肌梗死";
				break;
			case 107:
				mesage = "广泛前壁心肌梗死（急性）";
				break;
			case 108:
				mesage = "广泛前壁心肌梗死（近期内）";
				break;
			case 109:
				mesage = "广泛前壁心肌梗死（陈旧性）";
				break;
			case 110:
				mesage = "高位后壁心肌梗死可能";
				break;
			case 111:
				mesage = "高位后壁心肌梗死可能/或钟向转位";
				break;
			case 112:
				mesage = "窦性心律";
				break;
			case 113:
				mesage = "窦性心动过缓";
				break;
			case 114:
				mesage = "窦性心动过速";
				break;
			case 115:
				mesage = "窦性心律不齐";
				break;
			case 116:
				mesage = "窦房结传导阻滞或极度心律不齐";
				break;
			case 117:
				mesage = "心房内游走性节律";
				break;
			case 118:
				mesage = "窦房结内游走性节律";
				break;
			case 119:
				mesage = "交界性心律";
				break;
			case 120:
				mesage = "交界性心动过速";
				break;
			case 121:
				mesage = "左心房节律可能";
				break;
			case 122:
				mesage = "房性心动过速";
				break;
			case 123:
				mesage = "室性心律";
				break;
			case 124:
				mesage = "室性心动过速";
				break;
			case 125:
				mesage = "室上性心律";
				break;
			case 126:
				mesage = "室上性心动过速";
				break;
			case 127:
				mesage = "室上性心动过缓";
				break;
			case 128:
				mesage = "心律不明";
				break;
			case 129:
				mesage = "心律不明(心动过缓)";
				break;
			case 130:
				mesage = "心律不明(心动过速)";
				break;
			case 131:
				mesage = "不能确定的心律不齐";
				break;
			case 132:
				mesage = "房性逸搏";
				break;
			case 133:
				mesage = "房性逸搏心律";
				break;
			case 134:
				mesage = "过缓的房性逸搏心律";
				break;
			case 135:
				mesage = "加速的房性逸搏心律";
				break;
			case 136:
				mesage = "交界性逸搏";
				break;
			case 137:
				mesage = "交界性逸搏心律";
				break;
			case 138:
				mesage = "过缓的交界性逸搏心律";
				break;
			case 139:
				mesage = "加速的交界性逸搏心律";
				break;
			case 140:
				mesage = "室性逸搏";
				break;
			case 141:
				mesage = "室性逸搏心律";
				break;
			case 142:
				mesage = "过缓的室性逸搏心律";
				break;
			case 143:
				mesage = "加速的室性逸搏心律";
				break;
			case 144:
				mesage = "交界性早搏";
				break;
			case 145:
				mesage = "房性早搏";
				break;
			case 146:
				mesage = "心房早搏(频发性)";
				break;
			case 147:
				mesage = "心房早搏(二联律)";
				break;
			case 148:
				mesage = "心房早搏(三联律)";
				break;
			case 149:
				mesage = "室性早搏";
				break;
			case 150:
				mesage = "心室早搏(频发性)";
				break;
			case 151:
				mesage = "心室早搏(二联律)";
				break;
			case 152:
				mesage = "心室早搏(三联律)";
				break;
			case 153:
				mesage = "心房颤动";
				break;
			case 154:
				mesage = "心房扑动";
				break;
			case 155:
				mesage = "过缓型心房颤动";
				break;
			case 156:
				mesage = "过速型心房颤动";
				break;
			case 157:
				mesage = "运动实验（阳性）";
				break;
			case 158:
				mesage = "运动实验（阴性）";
				break;
			case 159:
				mesage = "运动实验（无法判断）";
				break;
			case 160:
				mesage = "正常范围心电图";
				break;
			case 200:
				mesage = "";
				break;
			case 201:
				mesage = "显著心率不齐";
				break;
			case 202:
				mesage = "窦性心律不齐";
				break;
			case 203:
				mesage = "显著窦性心律不齐";
				break;
			case 204:
				mesage = "窦性心律";
				break;
			case 205:
				mesage = "窦性心动过速";
				break;
			case 206:
				mesage = "窦性心动过缓";
				break;
			case 207:
				mesage = "房性心律";
				break;
			case 208:
				mesage = "心房颤动";
				break;
			case 209:
				mesage = "房颤伴快速心室率";
				break;
			case 210:
				mesage = "房颤伴缓慢心室率";
				break;
			case 211:
				mesage = "房颤伴室内差异传导或室性期前收缩";
				break;
			case 212:
				mesage = "快速室率房颤伴室内差异传导或室性早搏";
				break;
			case 213:
				mesage = "缓慢室率房颤伴室内差异传导或室性早搏";
				break;
			case 214:
				mesage = "房性心动过速";
				break;
			case 215:
				mesage = "心房扑动";
				break;
			case 216:
				mesage = "房扑伴室性差异传导或室性早搏";
				break;
			case 217:
				mesage = "不排除房扑";
				break;
			case 218:
				mesage = "交界性心律";
				break;
			case 219:
				mesage = "交界性心动过速";
				break;
			case 220:
				mesage = "未确定节律，可能室上性心律";
				break;
			case 221:
				mesage = "未确定节律，可能室上性心动过速";
				break;
			case 222:
				mesage = "未确定节律，可能室上性心动过缓";
				break;
			case 223:
				mesage = "偶发室上性早搏";
				break;
			case 224:
				mesage = "频发室上性早搏";
				break;
			case 225:
				mesage = "频发室上性早搏呈二联律";
				break;
			case 226:
				mesage = "偶发室性早搏";
				break;
			case 227:
				mesage = "不排除偶发室上性早搏";
				break;
			case 228:
				mesage = "频发室性早搏";
				break;
			case 229:
				mesage = "不排除频发室性早搏";
				break;
			case 230:
				mesage = "频发室性早搏呈二联律";
				break;
			case 231:
				mesage = "不排除频发室性早搏呈二联律";
				break;
			case 232:
				mesage = "成对室性早搏";
				break;
			case 233:
				mesage = "不排除成对室性早搏";
				break;
			case 234:
				mesage = "心房起博心律";
				break;
			case 235:
				mesage = "心室起博心律";
				break;
			case 236:
				mesage = "不排除心房起博心律";
				break;
			case 237:
				mesage = "不排除心室起博心律";
				break;
			case 238:
				mesage = "未确定的规整心律";
				break;
			case 239:
				mesage = "未确定的心律";
				break;
			case 240:
				mesage = "未确定的规整心动过速";
				break;
			case 241:
				mesage = "未确定的心动过速";
				break;
			case 242:
				mesage = "未确定的规整心动过缓";
				break;
			case 243:
				mesage = "未确定的心动过缓";
				break;
			case 244:
				mesage = "显著心动过缓";
				break;
			case 245:
				mesage = "偶发异位早搏";
				break;
			case 246:
				mesage = "不排除异位性早搏";
				break;
			case 247:
				mesage = "频发异位性早搏";
				break;
			case 248:
				mesage = "不排除频发异位性早搏";
				break;
			case 249:
				mesage = "频发异位性早搏呈二联率";
				break;
			case 250:
				mesage = "短 PR 间期 ";
				break;
			case 251:
				mesage = "WPW 综合症 A 型";
				break;
			case 252:
				mesage = "WPW 综合症 B 型";
				break;
			case 253:
				mesage = "不典型 WPW 综合症 A 型";
				break;
			case 254:
				mesage = "间歇性 WPW 综合症";
				break;
			case 255:
				mesage = "I 度房室传导阻滞";
				break;
			case 256:
				mesage = "II 度房室传导阻滞（莫氏 I 性）";
				break;
			case 257:
				mesage = "II 度房室传导阻滞（莫氏 II 性）";
				break;
			case 258:
				mesage = "可能 3 度房室阻滞";
				break;
			case 259:
				mesage = "非特异性室内传导延迟（QRS>110）";
				break;
			case 260:
				mesage = "非特异性室内传导阻滞（QRS>120）";
				break;
			case 261:
				mesage = "V1、V2 呈 RSR,右室传导阻滞";
				break;
			case 262:
				mesage = "不完全右束支传导阻滞";
				break;
			case 263:
				mesage = "完全性右束支传导阻滞";
				break;
			case 264:
				mesage = "完全右束支传导阻滞";
				break;
			case 265:
				mesage = "不完全性左束支传导阻滞";
				break;
			case 266:
				mesage = "完全性左束支阻滞";
				break;
			case 267:
				mesage = "左前分支阻滞";
				break;
			case 268:
				mesage = "左后分支阻滞";
				break;
			case 269:
				mesage = "不排除陈旧性前壁心梗";
				break;
			case 270:
				mesage = "不排除前壁心梗";
				break;
			case 271:
				mesage = "可能急性前壁心梗";
				break;
			case 272:
				mesage = "V3、V4 Q 波异常";
				break;
			case 273:
				mesage = "可能近期前壁心梗";
				break;
			case 274:
				mesage = "V3、V4 Q 波异常";
				break;
			case 275:
				mesage = "可能陈旧性前壁心梗";
				break;
			case 276:
				mesage = "可能前壁心梗";
				break;
			case 277:
				mesage = "可能急性前壁心梗";
				break;
			case 278:
				mesage = "V3、V4 Q 波异常";
				break;
			case 279:
				mesage = "前壁心梗";
				break;
			case 280:
				mesage = "V3、V4 Q 波异常";
				break;
			case 281:
				mesage = "前壁心梗";
				break;
			case 282:
				mesage = "前壁心梗";
				break;
			case 283:
				mesage = "不排除陈旧性前间壁心梗";
				break;
			case 284:
				mesage = "不排除陈旧性前间壁心梗";
				break;
			case 285:
				mesage = "可能急性前间壁心梗";
				break;
			case 286:
				mesage = "V2＋V3/V4 中 Q 波异常";
				break;
			case 287:
				mesage = "可能前间壁心梗";
				break;
			case 288:
				mesage = "V2＋V3/V4 中 Q 波异常";
				break;
			case 289:
				mesage = "可能陈旧性前壁心梗";
				break;
			case 290:
				mesage = "可能前间壁心梗";
				break;
			case 291:
				mesage = "前间壁心梗,可能为急性";
				break;
			case 292:
				mesage = "V2＋V3/V4 中 Q 波异常";
				break;
			case 293:
				mesage = "前间壁心梗";
				break;
			case 294:
				mesage = "V2＋V3/V4 中 Q 波异常";
				break;
			case 295:
				mesage = "前间壁心梗";
				break;
			case 296:
				mesage = "前间壁心梗";
				break;
			case 297:
				mesage = "不排除前侧壁心梗";
				break;
			case 298:
				mesage = "不排除前侧壁心梗";
				break;
			case 299:
				mesage = "可能前侧壁心梗";
				break;
			case 300:
				mesage = "I/avL/V3-V6 Q 波异常";
				break;
			case 301:
				mesage = "可能前侧壁心梗";
				break;
			case 302:
				mesage = "I/avL/V3-V6 Q 波异常";
				break;
			case 303:
				mesage = "可能前侧壁心梗";
				break;
			case 304:
				mesage = "可能前侧壁心梗";
				break;
			case 305:
				mesage = "前侧壁心梗";
				break;
			case 306:
				mesage = "I/avL/V3-V6 Q 波异常";
				break;
			case 307:
				mesage = "前侧壁心梗";
				break;
			case 308:
				mesage = "I/avL/V3-V6 Q 波异常";
				break;
			case 309:
				mesage = "前侧壁心梗";
				break;
			case 310:
				mesage = "前侧壁心梗";
				break;
			case 311:
				mesage = "不排除急性室间隔梗塞";
				break;
			case 312:
				mesage = "V2 异常 Q 波";
				break;
			case 313:
				mesage = "不排除近期室间隔梗塞";
				break;
			case 314:
				mesage = "V2 异常 Q 波";
				break;
			case 315:
				mesage = "不排除室间隔梗塞";
				break;
			case 316:
				mesage = "不排除室间隔梗塞";
				break;
			case 317:
				mesage = "可能室间隔梗塞";
				break;
			case 318:
				mesage = "V2 异常 Q 波";
				break;
			case 319:
				mesage = "可能室间隔梗塞";
				break;
			case 320:
				mesage = "V2 异常 Q 波";
				break;
			case 321:
				mesage = "可能室间隔梗塞";
				break;
			case 322:
				mesage = "可能室间隔梗塞";
				break;
			case 323:
				mesage = "室间隔梗塞";
				break;
			case 324:
				mesage = "V2 异常 Q 波";
				break;
			case 325:
				mesage = "室间隔梗塞";
				break;
			case 326:
				mesage = "V2 异常 Q 波";
				break;
			case 327:
				mesage = "室间隔梗塞";
				break;
			case 328:
				mesage = "室间隔梗塞";
				break;
			case 329:
				mesage = "不排除侧壁心梗";
				break;
			case 330:
				mesage = "不排除侧壁心梗";
				break;
			case 331:
				mesage = "可能侧壁心梗";
				break;
			case 332:
				mesage = "I/aVL/V5/V6 异常 Q 波";
				break;
			case 333:
				mesage = "可能侧壁性心梗";
				break;
			case 334:
				mesage = "I/aVL/V5/V6 异常 Q 波";
				break;
			case 335:
				mesage = "可能侧壁心梗";
				break;
			case 336:
				mesage = "可能侧壁心梗";
				break;
			case 337:
				mesage = "侧壁心梗";
				break;
			case 338:
				mesage = "I/aVL/V5/V6 异常 Q 波";
				break;
			case 339:
				mesage = "侧壁心梗";
				break;
			case 340:
				mesage = "I/aVL/V5/V6 异常 Q 波";
				break;
			case 341:
				mesage = "侧壁心梗";
				break;
			case 342:
				mesage = "侧壁心梗";
				break;
			case 343:
				mesage = "不排除陈旧性下壁心梗";
				break;
			case 344:
				mesage = "不排除扩展到后壁的陈旧性下壁心梗";
				break;
			case 345:
				mesage = "不排除下壁心梗";
				break;
			case 346:
				mesage = "不排除扩展到后壁的时期未确定下壁心梗";
				break;
			case 347:
				mesage = "可能急性下壁心梗";
				break;
			case 348:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 349:
				mesage = "可能扩展到后壁的急性下壁心梗";
				break;
			case 350:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 351:
				mesage = "可能近期下壁心梗";
				break;
			case 352:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 353:
				mesage = "可能扩展到后壁的近期下壁心梗";
				break;
			case 354:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 355:
				mesage = "可能陈旧性下壁心梗";
				break;
			case 356:
				mesage = "可能扩展到后壁的陈旧性下壁心梗";
				break;
			case 357:
				mesage = "可能下壁心梗";
				break;
			case 358:
				mesage = "可能扩展到后壁的下壁心梗";
				break;
			case 359:
				mesage = "下壁心梗";
				break;
			case 360:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 361:
				mesage = "可能扩展到后壁的急性下壁心梗";
				break;
			case 362:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 363:
				mesage = "下壁心梗";
				break;
			case 364:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 365:
				mesage = "可能扩展到后壁的近期下壁心梗";
				break;
			case 366:
				mesage = "II/aVF 异常 Q 波";
				break;
			case 367:
				mesage = "下壁心梗";
				break;
			case 368:
				mesage = "可能扩展到后壁的陈旧性下壁心梗";
				break;
			case 369:
				mesage = "下壁心梗";
				break;
			case 370:
				mesage = "扩展到后壁的下壁心梗";
				break;
			case 371:
				mesage = "ST 压低";
				break;
			case 372:
				mesage = "轻度 ST 段压低";
				break;
			case 373:
				mesage = "轻度 ST 段压低";
				break;
			case 374:
				mesage = "中度 ST 段压低";
				break;
			case 375:
				mesage = "中度 ST 段压低";
				break;
			case 376:
				mesage = "显著 ST 段压低";
				break;
			case 377:
				mesage = "显著 ST 段压低";
				break;
			case 378:
				mesage = "显著 ST 段压低";
				break;
			case 379:
				mesage = "J 点型 ST 段压低,大致正常";
				break;
			case 380:
				mesage = "异常 J 点型 ST 段压低";
				break;
			case 381:
				mesage = "ST 段抬高";
				break;
			case 382:
				mesage = "早期复极";
				break;
			case 383:
				mesage = "急性心包炎";
				break;
			case 384:
				mesage = "可能急性心包炎";
				break;
			case 385:
				mesage = "ST 段抬高";
				break;
			case 386:
				mesage = "非特异性 ST 抬高";
				break;
			case 387:
				mesage = "非特异性 ST-T 异常";
				break;
			case 388:
				mesage = "非特异性 ST-T 异常";
				break;
			case 389:
				mesage = "高耸 T 波";
				break;
			case 390:
				mesage = "非特异性 T 波异常";
				break;
			case 391:
				mesage = "非特异性 T 波异常";
				break;
			case 392:
				mesage = "可能前壁损伤或急性心梗";
				break;
			case 393:
				mesage = "前壁损伤或急性心梗";
				break;
			case 394:
				mesage = "T 波异常";
				break;
			case 395:
				mesage = "T 波异常";
				break;
			case 396:
				mesage = "T 波异常";
				break;
			case 397:
				mesage = "可能前间壁损伤或急性梗塞";
				break;
			case 398:
				mesage = "前间壁损伤或急性梗塞";
				break;
			case 399:
				mesage = "可能前侧壁损伤或急性梗塞";
				break;
			case 400:
				mesage = "前侧壁损伤或急性梗塞";
				break;
			case 401:
				mesage = "T 波异常";
				break;
			case 402:
				mesage = "T 波异常";
				break;
			case 403:
				mesage = "T 波异常";
				break;
			case 404:
				mesage = "可能室间隔损伤或急性梗塞";
				break;
			case 405:
				mesage = "室间隔损伤或急性梗塞";
				break;
			case 406:
				mesage = "可能侧壁损伤或急性梗塞";
				break;
			case 407:
				mesage = "侧壁损伤或急性心梗";
				break;
			case 408:
				mesage = "T 波异常";
				break;
			case 409:
				mesage = "T 波异常";
				break;
			case 410:
				mesage = "T 波异常";
				break;
			case 411:
				mesage = "可能下壁损伤或急性心梗";
				break;
			case 412:
				mesage = "下壁损伤或急性梗塞";
				break;
			case 413:
				mesage = "T 波异常";
				break;
			case 414:
				mesage = "T 波异常";
				break;
			case 415:
				mesage = "T 波异常";
				break;
			case 416:
				mesage = "可能右室肥厚";
				break;
			case 417:
				mesage = "右室肥厚";
				break;
			case 418:
				mesage = "右室肥厚伴复极异常";
				break;
			case 419:
				mesage = "轻度左室高压";
				break;
			case 420:
				mesage = "可能左室肥大";
				break;
			case 421:
				mesage = "中度左室高压";
				break;
			case 422:
				mesage = "左室高压";
				break;
			case 423:
				mesage = "左室高压伴复极异常";
				break;
			case 424:
				mesage = "可能右房增大";
				break;
			case 425:
				mesage = "右房增大";
				break;
			case 426:
				mesage = "可能左房增大";
				break;
			case 427:
				mesage = "左房增大";
				break;
			case 428:
				mesage = "电轴右偏";
				break;
			case 429:
				mesage = "中度电轴右偏";
				break;
			case 430:
				mesage = "电轴左偏";
				break;
			case 431:
				mesage = "中度电轴左偏";
				break;
			case 432:
				mesage = "电轴不定";
				break;
			case 433:
				mesage = "S1S2S3 型";
				break;
			case 434:
				mesage = "QRS－T 夹角异常";
				break;
			case 435:
				mesage = "符合肺部疾病";
				break;
			case 436:
				mesage = "QRS 波低电压";
				break;
			case 437:
				mesage = "肢体导联低电压";
				break;
			case 438:
				mesage = "胸导联低电压";
				break;
			case 439:
				mesage = "右位心";
				break;
			case 440:
				mesage = "长 QT 间期";
				break;
			case 441:
				mesage = "短 QT 间期";
				break;
			case 442:
				mesage = "正常心电图";
				break;
			case 443:
				mesage = "不典型心电图";
				break;
			case 444:
				mesage = "边缘心电图";
				break;
			case 445:
				mesage = "异常心律心电图";
				break;
			case 446:
				mesage = "异常心电图";
				break;
			case 447:
				mesage = "左右导联接反";
				break;
			case 448:
				mesage = "伪差";
				break;
			case 449:
				mesage = "心电图不能分析";
				break;
			case 450:
				mesage = "电极脱落";
				break;
			case 451:
				mesage = "根据固有 QRS 波形分析";
				break;
			case 452:
				mesage = "频发室性早搏呈三联律";
				break;
			case 453:
				mesage = "成串室性早搏";
				break;
			case 454:
				mesage = "室性心动过速";
				break;
			case 455:
				mesage = "漏搏";
				break;
		}
		return mesage;
	}

	public static void main(String[] args) {
		String result = analysisMessage("200;250;200;413;200;200;200;440;200;200");
		System.out.println(result);
	}

}
