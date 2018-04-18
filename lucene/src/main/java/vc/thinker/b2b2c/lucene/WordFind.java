package vc.thinker.b2b2c.lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.library.UserDefineLibrary;
import org.ansj.recognition.NatureRecognition;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.MyStaticValue;
import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.domain.Value;
import org.nlpcn.commons.lang.tire.library.Library;
import org.nlpcn.commons.lang.util.IOUtil;
import org.nlpcn.commons.lang.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 词查找，用于查找文档中存在指定词库中的词
 * 
 * @author james
 * 
 */
public class WordFind {

	private static final Logger log = LoggerFactory.getLogger(WordFind.class);

	private String wordPath;

	private String nature;

	/**
	 * 
	 * @param wordPath
	 *            词典路径
	 * @param nature
	 *            词性
	 */
	public WordFind(String wordPath, String nature) {
		this.wordPath = wordPath;
		this.nature = nature;
		Assert.hasText(this.wordPath, "word path is null");
		Assert.hasText(this.nature, "nature is null");
		loadWordPath(UserDefineLibrary.FOREST);
		MyStaticValue.isNameRecognition = false;
	}

	/**
	 * 查找词
	 * 
	 * @param text
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String[] find(String text) {
		List<Term> parse = new ToAnalysis().parse(text);
		new NatureRecognition(parse).recognition();
		List<String> result = new ArrayList<>();
		for (Term term : parse) {
			if (nature.equals(term.getNatureStr())) {
				result.add(term.getName());
			}
		}
		return result.toArray(new String[result.size()]);
	}

	private void loadWordPath(Forest forest) {

		InputStream is = WordFind.class.getResourceAsStream(wordPath);

		String temp = null;
		BufferedReader br = null;
		Value value = null;
		try {
			br = IOUtil.getReader(is, "UTF-8");
			while ((temp = br.readLine()) != null) {
				if (StringUtil.isBlank(temp)) {
					continue;
				} else {
					String str = temp.toLowerCase();

					value = new Value(str, nature, UserDefineLibrary.DEFAULT_FREQ_STR);
					Library.insertWord(forest, value);
				}
			}
			log.info("init word find library ok path is : " + wordPath);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(br);
			br = null;
		}
	}

	public static void main(String[] args) {
		WordFind wordFind = new WordFind("/dic/sensitive.dic", "sensitive");
		String[] words = wordFind.find("我的催眠水，好多人都用这玩意");
		for (String string : words) {
			System.out.println(string);
		}
	}
}
