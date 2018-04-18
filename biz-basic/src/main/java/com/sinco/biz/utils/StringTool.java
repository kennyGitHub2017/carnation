package com.sinco.biz.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringTool {
	private final static Pattern emailer = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+",
			Pattern.CASE_INSENSITIVE);

	/**
	 * 将map转换为字符串形式
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String mapToStr(Map map) {
		StringBuilder str = new StringBuilder();
		if (map == null || map.isEmpty()) {
			return null;
		}

		str.append("{\n");
		Iterator it = map.entrySet().iterator();

		for (int i = map.size() - 1; it.hasNext(); i--) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			String strTmp = null;
			if (val != null) {
				strTmp = val.toString();
				if (val instanceof Object[]) {
					strTmp = arrayToStr((Object[]) val);
				} else if (val instanceof int[]) {
					strTmp = arrayToStr((int[]) val);
				}
			}

			str.append("\t\t" + key + ": \t" + strTmp + (i == 0 ? "" : " \n"));
		}

		str.append("\n\t}");
		return str.toString();
	}

	/**
	 * 判断字符串是否符合Email格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		if (StringUtils.isNotBlank(str)) {
			Matcher isEmail = emailer.matcher(str);
			if (!isEmail.matches()) {
				return false;
			}
			return true;
		}

		return false;
	}

	/**
	 * 将Object数组转换为字符串形式
	 * 
	 * @param arr
	 *            Object[]
	 * @return String
	 */
	public static String arrayToStr(Object[] arr) {
		StringBuilder str = new StringBuilder();

		if (arr == null || arr.length < 1) {
			return null;
		}

		str.append("{");
		for (int i = 0; i < arr.length; i++) {
			str.append(arr[i] + ((i + 1) == arr.length ? "" : ", "));
		}
		str.append("}");

		return str.toString();
	}

	/**
	 * 将Object二维数组转换为字符串形式
	 * 
	 * @param arr
	 *            Object[][]
	 * @return String
	 */
	public static String arraysToStr(Object[][] arr) {
		StringBuilder str = new StringBuilder();

		if (arr == null || arr.length < 1) {
			return null;
		}

		str.append("{\n");
		for (int i = 0; i < arr.length; i++) {
			str.append("{");
			if (arr[i] == null) {
				continue;
			}

			for (int j = 0; j < arr[i].length; j++) {
				str.append(arr[i][j] + ((j + 1) == arr[i].length ? "" : ", "));
			}
			str.append("}" + ((i + 1) == arr.length ? "" : ", "));
		}
		str.append("\n}");

		return str.toString();
	}

	/**
	 * 将int数组转换为字符串形式
	 * 
	 * @param arr
	 *            int[]
	 * @return
	 */
	public static String arrayToStr(int[] arr) {
		StringBuilder str = new StringBuilder();

		if (arr == null || arr.length < 1) {
			return null;
		}

		str.append("{");
		for (int i = 0; i < arr.length; i++) {
			str.append(arr[i] + ((i + 1) == arr.length ? "" : ", "));
		}
		str.append("}");

		return str.toString();
	}

	/***************************************************************************
	 * 判断字串是否为空
	 **************************************************************************/
	public static boolean isRealEmpty(String inputString) {
		boolean isOK = false;
		if (inputString == null || "".equals(inputString.trim())) {
			isOK = true;
		}
		return isOK;
	}

	/**
	 * 生成随机密码
	 */
	public static String getRadomPassword() {
		StringBuffer generateRandStr = new StringBuffer();
		java.util.Random rand = new java.util.Random();
		int length = 8;
		char ch;
		for (int i = 0; i < length; i++) {
			int digital = rand.nextInt();
			int randNum = Math.abs(digital == Integer.MIN_VALUE ? rand.nextInt() : digital) % 26 + 97; // 产生97到122的随机数(a-
			// z的键位值)
			ch = (char) randNum;
			generateRandStr.append(ch);
		}
		return generateRandStr.toString();
	}

	/**
	 * 随机生成整数
	 * */
	public static int getRadomInt() {
		java.util.Random rand = new java.util.Random();
		int digital = rand.nextInt();
		int randNum = Math.abs(digital == Integer.MIN_VALUE ? rand.nextInt() : digital);
		return randNum;
	}

	/**
	 * 将输入字符串变为html显示字符串,added by qinhairong
	 */
	public static String convert2Html(String source) {
		String returnString = source;
		if (source == null || source.equals("")) {
			return "";
		}
		returnString = returnString.replaceAll("<", "&lt;");
		returnString = returnString.replaceAll(">", "&gt;");
		returnString = returnString.replaceAll(" ", "&nbsp;");
		returnString = returnString.replaceAll("\r\n", "<br/>");
		returnString = returnString.replaceAll("\"", "&quot;");
		// returnString = returnString.replaceAll( "", "&#039;");
		returnString = returnString.replaceAll(" ", "&nbsp;");
		returnString = returnString.replaceAll("\r", "<br/>");
		returnString = returnString.replaceAll("\n", "<br/>");
		returnString = returnString.replaceAll("&lt;br&gt;", "<br/>");

		return returnString;
	}

	/**
	 * 将输入字符串变为html显示字符串,added by qinhairong
	 */
	public static String convert2Resume(String source) {
		String returnString = source;
		if (source == null || source.equals("")) {
			return "";
		}
		returnString = returnString.replaceAll("<", "&lt;");
		returnString = returnString.replaceAll(">", "&gt;");
		returnString = returnString.replaceAll(" ", "&nbsp;");
		returnString = returnString.replaceAll("\r\n", "<br/>");
		// returnString = returnString.replaceAll( "", "&#039;");
		returnString = returnString.replaceAll(" ", "&nbsp;");
		returnString = returnString.replaceAll("\r", "<br/>");
		returnString = returnString.replaceAll("\n", "<br/>");
		returnString = returnString.replaceAll("&lt;br&gt;", "<br/>");

		return returnString;
	}

	/**
	 * 把html字符串变成可编辑的输入ascii字符
	 */

	public static String decodeHtml(String source) {
		String returnString = source;
		if (source == null || source.equals("")) {
			return "";
		}
		returnString = returnString.replaceAll("<br>", "\r\n");
		returnString = returnString.replaceAll("<br />", "\r\n");
		returnString = returnString.replaceAll("<br/>", "\r\n");
		returnString = returnString.replaceAll("<br&nbsp;/>", "\r\n");
		returnString = returnString.replaceAll("&lt;", "<");
		returnString = returnString.replaceAll("&gt;", ">");
		returnString = returnString.replaceAll("&nbsp;", " ");

		returnString = returnString.replaceAll("&quot;", "\"");
		// returnString = returnString.replaceAll( "", "&#039;");

		// returnString = returnString.replaceAll( "&lt;br&gt;", "<br>");

		return returnString;
	}

	/**
	 * 把html字符串变成可编辑的输入ascii字符
	 */

	public static String decodeHtmlNBSP(String source) {
		String returnString = source;
		if (source == null || source.equals("")) {
			return "";
		}
		// returnString = returnString.replaceAll("<br>", "\r\n");
		// returnString = returnString.replaceAll("&lt;", "<");
		// returnString = returnString.replaceAll("&gt;", ">");
		returnString = returnString.replaceAll("&nbsp;", " ");

		// returnString = returnString.replaceAll("&quot;", "\"");
		// returnString = returnString.replaceAll( "", "&#039;");

		// returnString = returnString.replaceAll( "&lt;br&gt;", "<br>");

		return returnString;
	}

	// 是否为整数
	public static boolean isNumeric(String str) {
		if (isRealEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**/// / <summary>
	// /将字符串格式化为HTML
	// / </summary>
	// / <param name="normalStr">所要格式化的字符串</param>
	// / <param name="identiftyURL">是否自动识别URL，识别出来的URL将会自动加上超级链接标签</param>
	// / <returns>返回格式化后的HTML代码</returns>
	/*
	 * public static String FormatToHTML(string normalStr, bool identiftyURL) {
	 * StringBuilder html = new StringBuilder(normalStr);
	 * 
	 * html.Append(' '); html.Replace("&", "&amp;"); html.Replace(" ",
	 * "&nbsp;"); html.Replace("<", "&lt;"); html.Replace(">", "&gt;");
	 * html.Replace("\"", "&quot;");
	 * 
	 * if (identiftyURL) { Regex linkRegex = new
	 * Regex("(http://|www)[\\S]{5,}(?=&nbsp;|\r\n)");
	 * 
	 * MatchCollection regMathes = linkRegex.Matches(html.ToString());
	 * 
	 * int add = 0;
	 * 
	 * foreach (Match match in regMathes) { string head = string.Format("<a
	 * href=\"{0}\">", match.Value[0] == 'h' ? match.Value : "http://" +
	 * match.Value);
	 * 
	 * html.Insert(match.Index + add, head); add += head.Length;
	 * 
	 * html.Insert(match.Index + match.Length + add, "</a>"); add += 3; } }
	 * 
	 * html.Replace("\r\n", "<br />");
	 * 
	 * return html.ToString(); }
	 */

	/**/// / <summary>
	// / 将HTML转为普通文本格式
	// / </summary>
	// / <param name="htmlStr">所要转换的HTML字符串</param>
	// / <param name="identiftyURL">是否自动识别URL，自动识别URL会自动去处HTML代码中的超级链接标签</param>
	// / <returns>返回普通文本</returns>
	/*
	 * public static string UnFormatHTML(string htmlStr, bool identiftyURL) {
	 * StringBuilder normalStr = new StringBuilder(htmlStr);
	 * 
	 * normalStr.Replace("<br />", "\r\n");
	 * 
	 * if (identiftyURL) { Regex linkRegex1 = new Regex("(<a
	 * href=\")[\\S]{5,}(\">)|</a>");
	 * 
	 * normalStr= new StringBuilder(linkRegex1.Replace(normalStr.ToString(),
	 * "")); }
	 * 
	 * normalStr.Replace("&quot;", "\""); normalStr.Replace("&lt;", "<");
	 * normalStr.Replace("&gt;", ">"); normalStr.Replace("&nbsp;", " ");
	 * normalStr.Replace("&amp;", "&");
	 * 
	 * return normalStr.ToString(); }
	 */
	public static String spellNumber(String nationCode, String directionCode, String tel, String subCode) {
		// 校验传真，如果传真号为空，返回空
		if (subCode == null || "".equals(subCode)) {
			if (tel == null || "".equals(tel)) {
				return "";
			}
		}

		// 如果区号为空就只返回tel+subCode
		if (isRealEmpty(directionCode)) {
			return spellTel(tel, subCode);
		} else {
			// 如果国家码为空，返回区号+tel+subcode
			if (!isRealEmpty(nationCode)) {
				return nationCode + "-" + directionCode + "-" + spellTel(tel, subCode);
			} else {
				return directionCode + "-" + spellTel(tel, subCode);
			}

		}

	}

	private static String spellTel(String tel, String subCode) {
		if (!isRealEmpty(tel)) {
			if (!isRealEmpty(subCode)) {
				return tel + "-" + subCode;
			} else {
				return tel;
			}
		}
		return "";
	}

	/**
	 * 得到规定行数和字数的字数的函数
	 */
	public static String getEscHtml(String sourceString, int length, int lines) {
		String returnString = null;
		if (sourceString == null) {
			return null;
		}

		// 得到要进行运算的字符串
		String source = decodeHtml(sourceString);
		source = source.replace("\r\n", "\n");
		// 开始遍历字符串
		int hasLines = 0;
		// 在当前行有几个字符
		int currentPostion = 0;
		// 一个单词已经有多少个字母
		int leterStart = 0;
		// 是否还有后续字符
		boolean lastLeter = false;
		// 一个数字已经有几个数字串了
		int digits = 0;
		// 是否还有后续数字
		boolean lastDigits = false;
		int i = 0;
		StringBuilder temp = new StringBuilder();
		for (; i < source.length(); i++) {
			// 如果行数已经完成的话，就可以退出了
			String letter = source.substring(i, i + 1);
			if (hasLines >= lines) {

				// 是否还有后续字符
				if (lastLeter) {
					for (int j = i; j < source.length(); j++) {
						String tempLetter = source.substring(j, j + 1);
						if (!isLetter(tempLetter)) {
							break;
						} else {
							temp.append(tempLetter);
						}
					}
				}

				// 是否还有后续数字
				if (lastDigits) {
					for (int j = i; j < source.length(); j++) {
						String tempLetter = source.substring(j, j + 1);
						if (!isDigital(tempLetter)) {
							break;
						} else {
							temp.append(tempLetter);
						}
					}
				}

				break;
			}
			lastLeter = false;
			lastDigits = false;
			if ("\n".equals(letter)) {
				temp.append(letter);
				hasLines++;
				currentPostion = 0;
				continue;
			}
			if (isChinese(letter) || " ".equals(letter)) {
				// 如果是汉字或空格，就算2个字长
				currentPostion++;
			}
			if (!isLetter(letter)) {
				leterStart = 0;
			} else {
				leterStart++;

			}
			if (digits > 0 && !isDigital(letter)) {
				digits = 0;
			} else if (digits == 0 && isTrueDigital(letter)) {
				digits++;
			}
			if (currentPostion >= length) {
				currentPostion = 0;
				if (leterStart != 0 && leterStart < temp.length() - 1) {
					// 如果发现一个单词不在一行，应该添加一个换行符号
					// for(int j=0;j<leterStart;j++){
					temp.insert(temp.length() - leterStart, "\n");

					// }

					currentPostion = leterStart;
					leterStart = 0;
					lastLeter = true;// 还有数字没完整
				} else if (digits != 0 && digits < temp.length() - 1) {
					temp.insert(temp.length() - digits, "\n");

					// }

					currentPostion = digits; // 提前几个字符
					digits = 0;
					lastDigits = true;// 还有数字没完整
				} else {
					if (!isChinese(letter)) {
						temp.append("\n");
					}
				}

				hasLines++;
				temp.append(letter);
				continue;
			}
			temp.append(letter);
			currentPostion++;
		}
		// returnString = source.substring(0, i);

		returnString = convert2Html(temp.toString());
		return returnString;
	}

	public static String getCorpDesc(String str, int length, int lines) {
		str = html2Text(str);
		return getEscHtml(str, length, lines);
	}

	public static String html2Text(String str) {
		while (str.indexOf("<") >= 0) {
			String str1 = "";
			String str2 = "";
			str1 = str.substring(0, str.indexOf("<"));
			str2 = str.substring(str.indexOf(">") + 1);
			str = str1 + str2;
		}
		return str;
	}

	/**
	 * 判断该字符串首字是否为汉字
	 */
	public static boolean isChinese(String source) {
		boolean isChinese = false;
		try {
			if (source != null) {
//                byte[] bytes = source.getBytes("Unicode");
//                // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
//                if (bytes[2] != 0)
//                {
//                    isChinese = true;
//                }
				String regEx = "[\u4E00-\u9FA5\uFE30-\uFFA0]";
				Pattern p = Pattern.compile(regEx);
				Matcher m = p.matcher(source);
				while (m.find()) {
					isChinese = true;
				}

			}
		} catch (Exception e) {

		}
		return isChinese;

	}

	/**
	 * 判断是否是字母
	 * 
	 * 
	 */
	public static boolean isLetter(String source) {
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}

	/**
	 * 判断是否是字母
	 * 
	 * 
	 */
	public static boolean isDigital(String source) {
		Pattern pattern = Pattern.compile("[0-9,]");
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}

	public static boolean isTrueDigital(String source) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}

	/**
	 * 得到格式化的数字
	 */
	public static String formatNumber(String format, double source) {
		NumberFormat formatter = new DecimalFormat(format);
		return formatter.format(source); // -1,235
		// -1,234,568

	}

	/**
	 * 是否为输入安全字符串
	 * */
	public static boolean isSecurity(String source) {
		if (source == null) {
			return true;
		}// (<(\\w+))| [\\w*]
			// Pattern pattern = Pattern.compile(
			// "[(<){1}(\\w+)]|[(<script){1}(\\w*)]|[(</script){1}(\\w*)]");
		Pattern pattern = Pattern.compile("([<>'`;%\"]{1}(\\w*))");
		Matcher matcher = pattern.matcher(source.toLowerCase());
		// matcher.find();
//System.out.println(matcher.group());
		return !matcher.find();
	}

	/**
	 * 判断是否有已经有点url 查询字，为true，已经有，为false；没有
	 * 
	 * **/
	public static boolean hasQueryString(String queryString) {
		if (queryString == null) {
			return false;
		}
		if (queryString.indexOf("?") != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 得到默认的格式化的数字
	 */
	public static String getDefaultFormatNumber(double source) {
		return formatNumber("###,###,###.##", source);
	}

	/**
	 * 得到以万为单位的年薪表示法 <功能详细描述>
	 * 
	 * @param minYearPay
	 * @param maxYearPay
	 * @return
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getYearPay(final Double minYearPay, final Double maxYearPay) {
		String returnValue = "";
		Double minyp = (minYearPay / 10000);
		Double maxyp = (maxYearPay / 10000);
		String unit = "万";
		String maxValue = "";
		if (maxyp.intValue() == 999) {
			maxValue = "100万以上";
			returnValue = maxValue;
		} else if (maxyp <= 0 || maxyp == null) {
			returnValue = minyp.intValue() + "以上";// 修改当未输入最大金额时显示min以上,修改人:robbi.guan

		} else {
			maxValue = "-" + String.valueOf(maxyp.intValue()) + unit;
			returnValue = minyp.intValue() + unit + maxValue;
		}

		return returnValue;
	}

	@SuppressWarnings("deprecation")
	public static int getYear(Date startDate, Date endDate) {
		return startDate.getYear() - endDate.getYear() + 1;
	}

	/*
	 * String str = "Java目前的发展史是由{0}年-{1}年"; String[][] object={new
	 * String[]{"\\{0\\}","1995"},new String[]{"\\{1\\}","2007"}};
	 * System.out.println(replace(str,object));
	 * 
	 * public static String replace(final String sourceString,Object[] object) {
	 * String temp=sourceString; for(int i=0;i<object.length;i++){ String[]
	 * result=(String[])object[i]; Pattern pattern = Pattern.compile(result[0]);
	 * Matcher matcher = pattern.matcher(temp);
	 * temp=matcher.replaceAll(result[1]); } return temp; }
	 */

//    public static void main(String[] args)
//    {
	// String test =
	// "您是一位善于创新、思维严密开阔、熟悉网站美工制作，同时拥有扎实PHOTOSHOP、DREAMWEAVER等常用网页设计工具的人么？那么，我们邀请您加入,&amp;nbsp;成为我们的伙伴，与我们一起拥抱您的未来。&lt;br&gt;&lt;br&gt;&lt;br&gt;职责&lt;br&gt;&lt;br&gt;&lt;br&gt;您的主要工作职责为：&lt;br&gt;&lt;br&gt;&lt;br&gt;1.配合技术部门，进行页面的调整和美化工作&lt;br&gt;&lt;br&gt;2.调整页面细节&lt;br&gt;&lt;br&gt;&lt;br&gt;&lt;br&gt;要求&lt;br&gt;&lt;br&gt;&lt;br&gt;以下要求，将作为您加入的首要条件：&lt;br&gt;&lt;br&gt;&amp;nbsp;&lt;br&gt;1、本科毕业，2年以上美工经验，精通各种常用网页设计工具，包括PHOTOSHOP，DREAMWEAVER等；&lt;br&gt;&lt;br&gt;2、精通HTML及DIV+CSS，精通JAVASCRIPT编程；&lt;br&gt;&lt;br&gt;3、有团队协作项目经验，能在较大工作压力的情况下很好的完成工作；&lt;br&gt;&lt;br&gt;4、做事认真、注意细节、效率高，有责任感，能吃苦。&lt;br&gt;&lt;br&gt;5、具有较好的沟通协调能力和团队协作精神&lt;br&gt;&lt;br&gt;&lt;br&gt;如果您曾经有过以下经历，那将会更好……&lt;br&gt;&lt;br&gt;网站美工设计经验&lt;br&gt;
	// ";
	// String
	// test=
	// "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请运营部按一下步骤开展新的产品开发：新动议在部门内部沉淀并通过COO审批后，提交设计方案给CEO细节商讨、修改和CEO审批交予技术部进行开发运营经理负责监督开发过程与产品质接下来，网站日常服务的执行和质量监管也以类似的方式进行：针对需要增加或优化的服务或监管措施提出动议，并通过COO审批提交方案与CEO和业务+客服部主管细节商讨、修改与定案&nbsp;交予业务+客服部执行&nbsp;运营经理负责监督执行的质量、并向COO与CEO反馈请运营部按一下步骤开展新的产品开发：新动议在部门内部沉淀并通过COO审批后，提交设计方案给CEO细节商讨、修改和CEO审批交予技术部进行开发运营经理负责监督开发过程与产品质接下来，网站日常服务的执行和质量监管也以类似的方式进行：针对需要增加或优化的服务或监管措施提出动议，并通过COO审批提交方案与CEO和业务+客服部主管细节商讨、修改与定案&nbsp;交予业务+客服部执行&nbsp;运营经理负责监督执行的质量、并向COO与CEO反<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
	// ;
	// String
	// test="建立、维护、扩大销售终端，达成销售目标、完成销售计划。<br><br>工作内容:<br><br>-&nbsp;积极扩大公司的知"
	// ;
	// String test =
	// "1、234324234234324234233专业彩票市场高级运营经验5—8年；<br>2、有福彩、体彩人脉关系优先考虑；<br>3、有彩票系统技术背景优先考虑；<br>4、至少有大型团队管理经验5年以上；<br>5、本科以上学历；<br>6、在福彩中心，体彩中心任职主任级别优先考虑。"
	// ;
	// System.out.println(StringTool.getEscHtml(test,10,5));
	// String test =
	// "Minimum&nbsp;Requirements：<br><br>Education:&nbsp;<br><br>•&nbsp;Bachelor's&nbsp;degree&nbsp;or&nbsp;equivalent*&nbsp;in&nbsp;Information&nbsp;Technology,&nbsp;Marketing,&nbsp;Computer&nbsp;Science,&nbsp;Engineering,&nbsp;Finance,&nbsp;MIS&nbsp;or&nbsp;related&nbsp;discipline.<br><br>Experience:&nbsp;<br><br>•&nbsp;Six&nbsp;(6)&nbsp;years&nbsp;related&nbsp;professional&nbsp;experience,&nbsp;in&nbsp;a&nbsp;face-to-face&nbsp;customer&nbsp;contact&nbsp;position.<br>•&nbsp;Management&nbsp;experience&nbsp;preferred.<br><br>Technical&nbsp;Expertise:<br><br>•&nbsp;Demonstrated&nbsp;ability&nbsp;to&nbsp;negotiate&nbsp;with&nbsp;customers.<br>•&nbsp;Knowledge&nbsp;of&nbsp;Windows&nbsp;NT,&nbsp;EDI,&nbsp;internet,&nbsp;intranet&nbsp;FedEx&nbsp;systems,&nbsp;pricing,&nbsp;billing,&nbsp;invoice&nbsp;adjustment,&nbsp;and&nbsp;Sales&nbsp;techniques.<"
	// ;
	// System.out.println(StringTool.getEscHtml(test,80,40));
	// System.out.println(Math.abs((new java.util.Random()).nextInt()));
	// System.out.println(getDefaultFormatNumber(1222211192334.011));
	// System.out.println(StringTool.isDigital("a"));
	// System.out.println(StringTool.decodeHtml(test));<>'`;%

//        System.out.println(StringTool.isSecurity("\""));
//
//    }

	// 判断字符串对象是否为null,为null则返回""
	public static String getNotNullStrValue(String str, String defStr) {
		if (StringUtils.isNotEmpty(str) && !str.trim().equals(""))
			return str;
		return defStr;
	}

	public static String getNotNullStrValue(String str) {
		return getNotNullStrValue(str, "");
	}

	/**
	 * 防SQL注入
	 * 
	 * @param str
	 * @return
	 ** @author 作者 Jeray.wu
	 * @version 创建时间：2009-10-23 下午05:42:20 方法说明
	 */
	public static boolean sql_inj(String str) {
		String inj_str = "':and:exec:insert:select:delete:update:count:*:%:chr:mid:master:truncate:char:declare:;:or:-:+:,";
		String inj_stra[] = inj_str.split(":");
		for (int i = 0; i < inj_stra.length; i++) {
			if (str.indexOf(inj_stra[i]) != -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <校验是否为正确的邮箱格式>
	 * 
	 * @param value
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean validateEmail(String value) {
		if (null != value && !"".equals(value)) {
			String check = "^(\\w+[-_.]?)+@((\\w+[-_]?)+\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
			Matcher matcher = regex.matcher((String) value);
			return matcher.matches();
		} else {
			return false;
		}
	}

	/**
	 * 簡體字轉化為繁體字
	 * 
	 * @param str
	 * @return
	 ** @author 作者 Jeray.wu
	 * @version 创建时间：2009-10-29 上午10:17:56 方法说明
	 */
	public static String cnTotw(String str) {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 256) {
				b.append(str.charAt(i));
				continue;
			}
			for (int j = 0; j < JT.length(); j++) {
				if (str.charAt(i) == JT.charAt(j)) {
					b.append(FT.charAt(j));
					break;
				}
				if (j == JT.length() - 1)// 没找到相应的字
					b.append(str.charAt(i));
			}
		}
		return b.toString();
	}

	/**
	 * 繁體轉換為簡體
	 * 
	 * @param str
	 * @return
	 ** @author 作者 Jeray.wu
	 * @version 创建时间：2009-10-29 上午10:24:17 方法说明
	 */
	public static String twTocn(String str) {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 256) {
				b.append(str.charAt(i));
				continue;
			}
			for (int j = 0; j < FT.length(); j++) {
				if (str.charAt(i) == FT.charAt(j)) {
					b.append(JT.charAt(j));
					break;
				}
				if (j == FT.length() - 1)// 没找到相应的字
					b.append(str.charAt(i));
			}
		}
		return b.toString();
	}

	/**
	 * <判断是否是url> <功能详细描述>
	 * 
	 * @param url
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isUrl(String url) {
		boolean flag = false;
		Pattern p = Pattern
				.compile(
						"^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$",
						Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(url);
		if (m.find()) {
			flag = true;
		}
		return flag;
	}

	static final String JT = "皑蔼碍爱翱袄奥坝罢摆败颁办绊帮绑镑谤剥饱宝报鲍辈贝钡狈备惫绷笔毕毙币闭边编贬变辩辫标鳖别瘪濒滨宾摈饼并拨钵铂驳卜补财参蚕残惭惨灿苍舱仓沧厕侧册测层诧搀掺蝉馋谗缠铲产阐颤场尝长偿肠厂畅钞车彻尘沉陈衬撑称惩诚骋痴迟驰耻齿炽冲虫宠畴踌筹绸丑橱厨锄雏础储触处传疮闯创锤纯绰辞词赐聪葱囱从丛凑蹿窜错达带贷担单郸掸胆惮诞弹当挡党荡档捣岛祷导盗灯邓敌涤递缔颠点垫电淀钓调迭谍叠钉顶锭订丢东动栋冻斗犊独读赌镀锻断缎兑队对吨顿钝夺堕鹅额讹恶饿儿尔饵贰发罚阀珐矾钒烦范贩饭访纺飞诽废费纷坟奋愤粪丰枫锋风疯冯缝讽凤肤辐抚辅赋复负讣妇缚该钙盖干赶秆赣冈刚钢纲岗皋镐搁鸽阁铬个给龚宫巩贡钩沟构购够蛊顾剐关观馆惯贯广规硅归龟闺轨诡柜贵刽辊滚锅国过骇韩汉号阂鹤贺横轰鸿红后壶护沪户哗华画划话怀坏欢环还缓换唤痪焕涣黄谎挥辉毁贿秽会烩汇讳诲绘荤浑伙获货祸击机积饥讥鸡绩缉极辑级挤几蓟剂济计记际继纪夹荚颊贾钾价驾歼监坚笺间艰缄茧检碱硷拣捡简俭减荐槛鉴践贱见键舰剑饯渐溅涧将浆蒋桨奖讲酱胶浇骄娇搅铰矫侥脚饺缴绞轿较秸阶节茎鲸惊经颈静镜径痉竞净纠厩旧驹举据锯惧剧鹃绢杰洁结诫届紧锦仅谨进晋烬尽劲荆觉决诀绝钧军骏开凯颗壳课垦恳抠库裤夸块侩宽矿旷况亏岿窥馈溃扩阔蜡腊莱来赖蓝栏拦篮阑兰澜谰揽览懒缆烂滥捞劳涝乐镭垒类泪篱离里鲤礼丽厉励砾历沥隶俩联莲连镰怜涟帘敛脸链恋炼练粮凉两辆谅疗辽镣猎临邻鳞凛赁龄铃凌灵岭领馏刘龙聋咙笼垄拢陇楼娄搂篓芦卢颅庐炉掳卤虏鲁赂禄录陆驴吕铝侣屡缕虑滤绿峦挛孪滦乱抡轮伦仑沦纶论萝罗逻锣箩骡骆络妈玛码蚂马骂吗买麦卖迈脉瞒馒蛮满谩猫锚铆贸么霉没镁门闷们锰梦谜弥觅幂绵缅庙灭悯闽鸣铭谬谋亩钠纳难挠脑恼闹馁内拟腻撵捻酿鸟聂啮镊镍柠狞宁拧泞钮纽脓浓农疟诺欧鸥殴呕沤盘庞赔喷鹏骗飘频贫苹凭评泼颇扑铺朴谱栖凄脐齐骑岂启气弃讫牵扦钎铅迁签谦钱钳潜浅谴堑枪呛墙蔷强抢锹桥乔侨翘窍窃钦亲寝轻氢倾顷请庆琼穷趋区躯驱龋颧权劝却鹊确让饶扰绕热韧认纫荣绒软锐闰润洒萨鳃赛叁伞丧骚扫涩杀纱筛晒删闪陕赡缮伤赏烧绍赊摄慑设绅审婶肾渗声绳胜圣师狮湿诗尸时蚀实识驶势适释饰视试寿兽枢输书赎属术树竖数帅双谁税顺说硕烁丝饲耸怂颂讼诵擞苏诉肃虽随绥岁孙损笋缩琐锁獭挞抬态摊贪瘫滩坛谭谈叹汤烫涛绦讨腾誊锑题体屉条贴铁厅听烃铜统头秃图涂团颓蜕脱鸵驮驼椭洼袜弯湾顽万网韦违围为潍维苇伟伪纬谓卫温闻纹稳问瓮挝蜗涡窝卧呜钨乌污诬无芜吴坞雾务误锡牺袭习铣戏细虾辖峡侠狭厦吓锨鲜纤咸贤衔闲显险现献县馅羡宪线厢镶乡详响项萧嚣销晓啸蝎协挟携胁谐写泻谢锌衅兴汹锈绣虚嘘须许叙绪续轩悬选癣绚学勋询寻驯训讯逊压鸦鸭哑亚讶阉烟盐严颜阎艳厌砚彦谚验鸯杨扬疡阳痒养样瑶摇尧遥窑谣药爷页业叶医铱颐遗仪彝蚁艺亿忆义诣议谊译异绎荫阴银饮隐樱婴鹰应缨莹萤营荧蝇赢颖哟拥佣痈踊咏涌优忧邮铀犹游诱舆鱼渔娱与屿语吁御狱誉预驭鸳渊辕园员圆缘远愿约跃钥岳粤悦阅云郧匀陨运蕴酝晕韵杂灾载攒暂赞赃脏凿枣灶责择则泽贼赠扎札轧铡闸栅诈斋债毡盏斩辗崭栈战绽张涨帐账胀赵蛰辙锗这贞针侦诊镇阵挣睁狰争帧郑证织职执纸挚掷帜质滞钟终种肿众诌轴皱昼骤猪诸诛烛瞩嘱贮铸筑驻专砖转赚桩庄装妆壮状锥赘坠缀谆着浊兹资渍踪综总纵邹诅组钻";
	static final String FT = "皚藹礙愛翺襖奧壩罷擺敗頒辦絆幫綁鎊謗剝飽寶報鮑輩貝鋇狽備憊繃筆畢斃幣閉邊編貶變辯辮標鼈別癟瀕濱賓擯餅並撥缽鉑駁蔔補財參蠶殘慚慘燦蒼艙倉滄廁側冊測層詫攙摻蟬饞讒纏鏟産闡顫場嘗長償腸廠暢鈔車徹塵沈陳襯撐稱懲誠騁癡遲馳恥齒熾沖蟲寵疇躊籌綢醜櫥廚鋤雛礎儲觸處傳瘡闖創錘純綽辭詞賜聰蔥囪從叢湊躥竄錯達帶貸擔單鄲撣膽憚誕彈當擋黨蕩檔搗島禱導盜燈鄧敵滌遞締顛點墊電澱釣調叠諜疊釘頂錠訂丟東動棟凍鬥犢獨讀賭鍍鍛斷緞兌隊對噸頓鈍奪墮鵝額訛惡餓兒爾餌貳發罰閥琺礬釩煩範販飯訪紡飛誹廢費紛墳奮憤糞豐楓鋒風瘋馮縫諷鳳膚輻撫輔賦複負訃婦縛該鈣蓋幹趕稈贛岡剛鋼綱崗臯鎬擱鴿閣鉻個給龔宮鞏貢鈎溝構購夠蠱顧剮關觀館慣貫廣規矽歸龜閨軌詭櫃貴劊輥滾鍋國過駭韓漢號閡鶴賀橫轟鴻紅後壺護滬戶嘩華畫劃話懷壞歡環還緩換喚瘓煥渙黃謊揮輝毀賄穢會燴彙諱誨繪葷渾夥獲貨禍擊機積饑譏雞績緝極輯級擠幾薊劑濟計記際繼紀夾莢頰賈鉀價駕殲監堅箋間艱緘繭檢堿鹼揀撿簡儉減薦檻鑒踐賤見鍵艦劍餞漸濺澗將漿蔣槳獎講醬膠澆驕嬌攪鉸矯僥腳餃繳絞轎較稭階節莖鯨驚經頸靜鏡徑痙競淨糾廄舊駒舉據鋸懼劇鵑絹傑潔結誡屆緊錦僅謹進晉燼盡勁荊覺決訣絕鈞軍駿開凱顆殼課墾懇摳庫褲誇塊儈寬礦曠況虧巋窺饋潰擴闊蠟臘萊來賴藍欄攔籃闌蘭瀾讕攬覽懶纜爛濫撈勞澇樂鐳壘類淚籬離裏鯉禮麗厲勵礫曆瀝隸倆聯蓮連鐮憐漣簾斂臉鏈戀煉練糧涼兩輛諒療遼鐐獵臨鄰鱗凜賃齡鈴淩靈嶺領餾劉龍聾嚨籠壟攏隴樓婁摟簍蘆盧顱廬爐擄鹵虜魯賂祿錄陸驢呂鋁侶屢縷慮濾綠巒攣孿灤亂掄輪倫侖淪綸論蘿羅邏鑼籮騾駱絡媽瑪碼螞馬罵嗎買麥賣邁脈瞞饅蠻滿謾貓錨鉚貿麽黴沒鎂門悶們錳夢謎彌覓冪綿緬廟滅憫閩鳴銘謬謀畝鈉納難撓腦惱鬧餒內擬膩攆撚釀鳥聶齧鑷鎳檸獰甯擰濘鈕紐膿濃農瘧諾歐鷗毆嘔漚盤龐賠噴鵬騙飄頻貧蘋憑評潑頗撲鋪樸譜棲淒臍齊騎豈啓氣棄訖牽扡釺鉛遷簽謙錢鉗潛淺譴塹槍嗆牆薔強搶鍬橋喬僑翹竅竊欽親寢輕氫傾頃請慶瓊窮趨區軀驅齲顴權勸卻鵲確讓饒擾繞熱韌認紉榮絨軟銳閏潤灑薩鰓賽三傘喪騷掃澀殺紗篩曬刪閃陝贍繕傷賞燒紹賒攝懾設紳審嬸腎滲聲繩勝聖師獅濕詩屍時蝕實識駛勢適釋飾視試壽獸樞輸書贖屬術樹豎數帥雙誰稅順說碩爍絲飼聳慫頌訟誦擻蘇訴肅雖隨綏歲孫損筍縮瑣鎖獺撻擡態攤貪癱灘壇譚談歎湯燙濤縧討騰謄銻題體屜條貼鐵廳聽烴銅統頭禿圖塗團頹蛻脫鴕馱駝橢窪襪彎灣頑萬網韋違圍爲濰維葦偉僞緯謂衛溫聞紋穩問甕撾蝸渦窩臥嗚鎢烏汙誣無蕪吳塢霧務誤錫犧襲習銑戲細蝦轄峽俠狹廈嚇鍁鮮纖鹹賢銜閑顯險現獻縣餡羨憲線廂鑲鄉詳響項蕭囂銷曉嘯蠍協挾攜脅諧寫瀉謝鋅釁興洶鏽繡虛噓須許敘緒續軒懸選癬絢學勳詢尋馴訓訊遜壓鴉鴨啞亞訝閹煙鹽嚴顔閻豔厭硯彥諺驗鴦楊揚瘍陽癢養樣瑤搖堯遙窯謠藥爺頁業葉醫銥頤遺儀彜蟻藝億憶義詣議誼譯異繹蔭陰銀飲隱櫻嬰鷹應纓瑩螢營熒蠅贏穎喲擁傭癰踴詠湧優憂郵鈾猶遊誘輿魚漁娛與嶼語籲禦獄譽預馭鴛淵轅園員圓緣遠願約躍鑰嶽粵悅閱雲鄖勻隕運蘊醞暈韻雜災載攢暫贊贓髒鑿棗竈責擇則澤賊贈紮劄軋鍘閘柵詐齋債氈盞斬輾嶄棧戰綻張漲帳賬脹趙蟄轍鍺這貞針偵診鎮陣掙睜猙爭幀鄭證織職執紙摯擲幟質滯鍾終種腫衆謅軸皺晝驟豬諸誅燭矚囑貯鑄築駐專磚轉賺樁莊裝妝壯狀錐贅墜綴諄著濁茲資漬蹤綜總縱鄒詛組鑽";

	public static String getFileSuffix(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			String suffix = fileName.substring(index + 1);// 后缀
			suffix = suffix.toLowerCase();
			return suffix;
		} else {
			return null;
		}
	}

	public static String getFileName(String filePath) {
		int startIndex = filePath.lastIndexOf("/");
		int endIndex = filePath.lastIndexOf(".");
		if (startIndex != -1 && endIndex != -1) {
			return filePath.substring(startIndex + 1, endIndex);
		}
		return null;
	}

//        public static void main(String[] args) {
//        	//boolean bo = StringTool.isEmailString("bily.liu@aceona.com");
//        	String url = "/opt/tomcat/webapps/FileServer/lts_uploadfile/2014/1/2/2014-01-02-030621520/潘启文-耐消销售总.Html";
//        	String suffix = StringTool.getFileSuffix(url);
//        	String filName = url.substring(url.lastIndexOf("/") + 1,url.lastIndexOf("."));
//        	System.out.println(filName);
//        	
//    	}
}
