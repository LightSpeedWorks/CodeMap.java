/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

import java.util.ArrayList;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapArrayList {
	static final int NOT_FOUND = -1;
	ArrayList<Integer> array = new ArrayList<Integer>();

	/**
	 * creates character code mapping table
	 * {文字コードマッピングテーブル作成}
	 */
	public CodeMapArrayList() {
	}

	/**
	 * deletes character code mapping table
	 * {文字コードマッピングテーブル削除}
	 */
	public void delete() {
		array.removeAll(array);
	}

	/**
	 * sets value to character code mapping table
	 * {文字コードマッピングに値を設定}
	 *
	 * @param index integer index {整数インデックス}
	 * @param value integer value {整数値}
	 */
	public CodeMapArrayList set(int index, int value) {
		array.add(index, value);
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
		if (index < 0 || index >= array.size())
			return NOT_FOUND;
//		if (index < 0 || index >= array.size())
//			throw new IndexOutOfBoundsException("");
		return array.get(index);
	}
}
