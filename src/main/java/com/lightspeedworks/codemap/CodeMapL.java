/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

import java.util.List;
import java.lang.IndexOutOfBoundsException;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapL<L extends List<Integer>> implements ICodeMap {
	public static final int NOT_FOUND = -1;
	L list = null;

	/**
	 * creates character code mapping table {文字コードマッピングテーブル作成}
	 */
	public CodeMapL(L list) {
		this.list = list;
	}

	/**
	 * deletes character code mapping table {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * sets value to character code mapping table {文字コードマッピングに値を設定}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @param value
	 *            integer value {整数値}
	 */
	public CodeMapL<L> set(int index, int value) {
		if (index < 0)
			throw new IndexOutOfBoundsException("index = " + index);
		int n = list.size();
		if (index < n) {
			list.set(index, value);
		}
		else {
			for (int i = n; i < index; ++i)
				list.add(NOT_FOUND);
			list.add(value);
		}
		return this;
	}

	/**
	 * gets value from character code mapping table {文字コードマッピングの値を取得}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @return integer value {整数値}
	 */
	public int get(int index) {
		if (index < 0 || index >= list.size())
			return NOT_FOUND;
		// if (index < 0 || index >= list.size())
		// throw new IndexOutOfBoundsException("");
		return list.get(index);
	}
}
