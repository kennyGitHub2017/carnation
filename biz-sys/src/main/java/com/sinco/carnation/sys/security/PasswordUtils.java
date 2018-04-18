package com.sinco.carnation.sys.security;

import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.sinco.common.utils.Encodes;

/**
 * 密码工具类
 * 
 * @author james
 * 
 */
public class PasswordUtils {

	public static final String HASH_ALGORITHM = "SHA-1";

	public static final int HASH_INTERATIONS = 1024;

	public static final int SALT_SIZE = 8;

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证密码
	 * 
	 * @param plainPassword
	 *            明文密码
	 * @param password
	 *            密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		if (null == plainPassword || "".equals(plainPassword))
			return false;
		byte[] salt = Encodes.decodeHex(password.substring(0, 16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
	}

	/**
	 * 验证密码
	 * 
	 * @param plainPassword
	 *            明文密码
	 * @param password
	 *            密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validateCNPassword(String plainPassword, String password) {
		if (null == plainPassword || "".equals(plainPassword) || password == null)
			return false;
		return password.equals(Md5Encrypt.md5(plainPassword).toLowerCase());
	}
	
	public static void main(String[] args)
	{
		String plainPassword = "123456";
		String password = "94dcaf27170f5ab6e804bbc37ed75b96e142ddcb7a7a3799578eca9d";
		System.out.println(PasswordUtils.validatePassword(plainPassword, password));
	}
}
