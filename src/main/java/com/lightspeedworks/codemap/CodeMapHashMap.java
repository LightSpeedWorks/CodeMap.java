/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

import java.util.HashMap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapHashMap {
	static final int NOT_FOUND = -1;
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

	/**
	 * creates character code mapping table
	 * {文字コードマッピングテーブル作成}
	 */
	public CodeMapHashMap() {
	}

	/**
	 * deletes character code mapping table
	 * {文字コードマッピングテーブル削除}
	 */
	public void delete() {
		hashMap.clear();
	}

	/**
	 * sets value to character code mapping table
	 * {文字コードマッピングに値を設定}
	 *
	 * @param index integer index {整数インデックス}
	 * @param value integer value {整数値}
	 */
	public CodeMapHashMap set(int index, int value) {
		hashMap.put(index, value);
		return this;
	}

	/**
	 * gets value from character code mapping table
	 * {文字コードマッピングの値を取得}
	 *
	 * @param index integer index {整数インデックス}
	 * @return integer value {整数値}
	 */
	public int get(int index) {
//		if (index < 0 || index >= hashMap.size())
//			return NOT_FOUND;
//		if (index < 0 || index >= array.size())
//			throw new IndexOutOfBoundsException("");
		try {
			return hashMap.get(index);
		} catch (Exception e) {
			return NOT_FOUND;
		}
	}
}
