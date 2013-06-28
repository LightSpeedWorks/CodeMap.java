package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap31 implements ICodeMap {
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
	int[][][] map = null;

	/**
	 * map short cut.
	 */
	final int[][] map10 = new int[MAX_INDEX_ONE][];

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i1 = 0; i1 < MAX_INDEX_ONE; ++i1)
			map10[i1] = null;

		map = null;
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
	public CodeMap31 set(final int index, final int value) {
		final int i0 = index >>> 24;
		final int i1 = (index >>> 12) & 0xfff;
		final int i2 = index & 0xfff;

		if (i0 == 0) {
			int[] map2 = map10[i1];
			if (map2 == null) {
				map2 = map10[i1] = new int[MAX_INDEX_TWO];
				for (int i = 0; i < MAX_INDEX_TWO; ++i)
					map2[i] = NOT_FOUND;
			}
			map2[i2] = value;
			return this;
		}

		if (map != null)
			map = new int[MAX_INDEX_ZERO][][];

		int[][] map1 = map[i0];
		if (map1 == null)
			map1 = map[i0] = new int[MAX_INDEX_ONE][];

		int[] map2 = map1[i1];
		if (map2 == null) {
			map2 = map1[i1] = new int[MAX_INDEX_TWO];
			for (int i = 0; i < MAX_INDEX_TWO; ++i)
				map2[i] = NOT_FOUND;
		}
		map2[i2] = value;
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
		final int i0 = index >>> 24;
		final int i1 = (index >>> 12) & 0xfff;
		final int i2 = index & 0xfff;

		if (i0 == 0) {
			int[] map2 = map10[i1];
			if (map2 == null)
				return NOT_FOUND;

			return map2[i2];
		}

		int[][] map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		int[] map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		return map2[i2];

		// if (i0 == 0) {
		// if (map10[i1] == null)
		// return NOT_FOUND;
		//
		// return map10[i1][i2];
		// }
		//
		// if (map[i0] == null)
		// return NOT_FOUND;
		//
		// if (map[i0][i1] == null)
		// return NOT_FOUND;
		//
		// return map[i0][i1][i2];
	}
}
