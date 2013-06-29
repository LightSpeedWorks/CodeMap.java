package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap4 implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * max index.
	 */
	static final int MAX_INDEX = 0x100;

	/**
	 * map.
	 */
	final int[][][][] map = new int[MAX_INDEX][][][];

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i = 0; i < MAX_INDEX; ++i)
			map[i] = null;
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
	public CodeMap4 set(final int index, final int value) {
		final int i0 = index >>> 24;
		int[][][] map1 = map[i0];
		if (map1 == null)
			map[i0] = map1 = new int[MAX_INDEX][][];

		final int i1 = (index >>> 16) & 0xff;
		int[][] map2 = map1[i1];
		if (map2 == null)
			map1[i1] = map2 = new int[MAX_INDEX][];

		final int i2 = (index >>> 8) & 0xff;
		int[] map3 = map2[i2];
		if (map3 == null) {
			map2[i2] = map3 = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = NOT_FOUND;
		}

		map3[index & 0xff] = value;
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
		int[][][] map1 = map[index >>> 24];
		if (map1 == null)
			return NOT_FOUND;

		int[][] map2 = map1[(index >>> 16) & 0xff];
		if (map2 == null)
			return NOT_FOUND;

		int[] map3 = map2[(index >>> 8) & 0xff];
		if (map3 == null)
			return NOT_FOUND;

		return map3[index & 0xff];
	}
}
