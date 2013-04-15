/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap2 implements ICodeMap {
	static final int NOT_FOUND = -1;
	static final int MAX_INDEX = 0x10000;
	int[][] map;

	/**
	 * creates character code mapping table {文字コードマッピングテーブル作成}
	 */
	public CodeMap2() {
		map = new int[MAX_INDEX][];
		for (int i = 0; i < MAX_INDEX; ++i)
			map[i] = null;
	}

	/**
	 * deletes character code mapping table {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		// if (map == null)
		// return;

		for (int i0 = 0; i0 < MAX_INDEX; ++i0) {
			int[] map1 = map[i0];
			if (map1 == null)
				continue;
			for (int i1 = 0; i1 < MAX_INDEX; ++i1)
				map1[i1] = NOT_FOUND;
			map[i0] = null;
		}
		// map = null;
	}

	/**
	 * sets value to character code mapping table {文字コードマッピングに値を設定}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @param value
	 *            integer value {整数値}
	 */
	public CodeMap2 set(int index, int value) {
		// if (map == null) {
		// map = new int[MAX_INDEX][];
		// for (int i = 0; i < MAX_INDEX; ++i)
		// map[i] = null;
		// }

		int i0 = index >>> 16;
		int[] map1 = map[i0];
		if (map1 == null) {
			map1 = map[i0] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = NOT_FOUND;
		}

		int i1 = index & 0xffff;
		map1[i1] = value;
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
		// if (map == null)
		// return NOT_FOUND;

		int i0 = index >>> 16;
		int[] map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		int i1 = index & 0xffff;
		return map1[i1];
	}
}
