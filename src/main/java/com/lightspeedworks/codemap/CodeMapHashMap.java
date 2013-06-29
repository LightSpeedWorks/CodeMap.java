package com.lightspeedworks.codemap;

import java.util.HashMap;
import java.util.Map;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapHashMap implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * map.
	 */
	final Map<Integer, Integer> map = new HashMap<Integer, Integer>();;

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		map.clear();
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
	public CodeMapHashMap set(final int index, final int value) {
		map.put(index, value);
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
		try {
			Integer result = map.get(index);
			if (result == null)
				return NOT_FOUND;
			return result;
		} catch (Exception e) {
			return NOT_FOUND;
		}
	}
}
