package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap2 implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * max index.
	 */
	static final int MAX_INDEX = 0x10000;

	/**
	 * map.
	 */
	final int[][] map = new int[MAX_INDEX][];

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMap2() {
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i0 = 0; i0 < MAX_INDEX; ++i0)
			map[i0] = null;
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
	public CodeMap2 set(final int index, final int value) {
		final int i0 = index >>> 16;
		int[] map1 = map[i0];
		if (map1 == null) {
			map1 = map[i0] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = NOT_FOUND;
		}

		// final int i1 = index & 0xffff;
		// map1[i1] = value;
		map1[index & 0xffff] = value;
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
		// final int i0 = index >>> 16;
		final int[] map1 = map[index >>> 16];
		if (map1 == null)
			return NOT_FOUND;

		// final int i1 = index & 0xffff;
		return map1[index & 0xffff];
	}
}
