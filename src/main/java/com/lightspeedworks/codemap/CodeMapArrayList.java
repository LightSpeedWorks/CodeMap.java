package com.lightspeedworks.codemap;

import java.util.ArrayList;
import java.util.List;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapArrayList implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * list.
	 */
	final List<Integer> list;

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMapArrayList() {
		list = new ArrayList<Integer>();
	}

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 *
	 * @param size
	 *            int
	 *
	 * @returns CodeMap
	 */
	public CodeMapArrayList(int size) {
		list = new ArrayList<Integer>(size);
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * sets value to character code mapping table. {文字コードマッピングに値を設定}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @param value
	 *            integer value {整数値}
	 * @return CodeMap
	 */
	public CodeMapArrayList set(final int index, final int value) {
		if (index < 0)
			throw new IndexOutOfBoundsException("index = " + index);
		final int n = list.size();
		if (index < n)
			list.set(index, value);
		else {
			for (int i = n; i < index; ++i)
				list.add(NOT_FOUND);
			list.add(value);
		}
		return this;
	}

	/**
	 * gets value from character code mapping table. {文字コードマッピングの値を取得}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @return integer value {整数値}
	 */
	public int get(final int index) {
		if (index < 0 || index >= list.size())
			return NOT_FOUND;

		return list.get(index);
	}
}
