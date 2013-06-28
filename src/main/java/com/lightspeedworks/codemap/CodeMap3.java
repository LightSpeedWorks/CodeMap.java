package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap3 implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * max index 0: zero.
	 */
	static final int MAX_INDEX_ZERO = 0x100;

	/**
	 * max index 1: one.
	 */
	static final int MAX_INDEX_ONE = 0x1000;

	/**
	 * max index 2: two.
	 */
	static final int MAX_INDEX_TWO = 0x1000;

	/**
	 * map.
	 */
	final int[][][] map = new int[MAX_INDEX_ZERO][][];

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMap3() {
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i0 = 0; i0 < MAX_INDEX_ZERO; ++i0)
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
	public CodeMap3 set(final int index, final int value) {
		final int i0 = index >>> 24;
		int[][] map1 = map[i0];
		if (map1 == null)
			map1 = map[i0] = new int[MAX_INDEX_ONE][];

		final int i1 = (index >>> 12) & 0xfff;
		int[] map2 = map1[i1];
		if (map2 == null) {
			map2 = map1[i1] = new int[MAX_INDEX_TWO];
			for (int i = 0; i < MAX_INDEX_TWO; ++i)
				map2[i] = NOT_FOUND;
		}

//		final int i2 = index & 0xfff;
//		map2[i2] = value;
		map2[index & 0xfff] = value;
		return this;
	}

	/**
	 * gets value from character code mapping table. {文字コードマッピングの値を取得}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @return integer value {整数値}
	 */
	public int get(int index) {
		// final int i0 = index >>> 24;
		// final int[][] map1 = map[i0];
		final int[][] map1 = map[index >>> 24];
		if (map1 == null)
			return NOT_FOUND;

		// final int i1 = (index >>> 12) & 0xfff;
		// final int[] map2 = map1[i1];
		final int[] map2 = map1[(index >>> 12) & 0xfff];
		if (map2 == null)
			return NOT_FOUND;

		// final int i2 = index & 0xfff;
		// return map2[i2];
		return map2[index & 0xfff];
	}
}
