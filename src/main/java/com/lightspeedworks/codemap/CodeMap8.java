package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 * 
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap8 implements ICodeMap {
	// /**
	// * not found.
	// */
	// public static final int NOT_FOUND = Integer.MIN_VALUE;

	/**
	 * max index.
	 */
	static final int MAX_INDEX = 0x10;

	/**
	 * map.
	 */
	final int[][][][][][][][] map = new int[MAX_INDEX][][][][][][][];

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMap8() {
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
	public CodeMap8 set(final int index, final int value) {
		final int i0 = index >>> 28;
		int[][][][][][][] map1 = map[i0];
		if (map1 == null)
			map1 = map[i0] = new int[MAX_INDEX][][][][][][];

		final int i1 = (index >>> 24) & 0xf;
		int[][][][][][] map2 = map1[i1];
		if (map2 == null)
			map2 = map1[i1] = new int[MAX_INDEX][][][][][];

		final int i2 = (index >>> 20) & 0xf;
		int[][][][][] map3 = map2[i2];
		if (map3 == null)
			map3 = map2[i2] = new int[MAX_INDEX][][][][];

		final int i3 = (index >>> 16) & 0xf;
		int[][][][] map4 = map3[i3];
		if (map4 == null)
			map4 = map3[i3] = new int[MAX_INDEX][][][];

		final int i4 = (index >>> 12) & 0xf;
		int[][][] map5 = map4[i4];
		if (map5 == null)
			map5 = map4[i4] = new int[MAX_INDEX][][];

		final int i5 = (index >>> 8) & 0xf;
		int[][] map6 = map5[i5];
		if (map6 == null)
			map6 = map5[i5] = new int[MAX_INDEX][];

		final int i6 = (index >>> 4) & 0xf;
		int[] map7 = map6[i6];
		if (map7 == null) {
			map7 = map6[i6] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map7[i] = NOT_FOUND;
		}

		final int i7 = index & 0xf;
		map7[i7] = value;
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
		int i0 = index >>> 28;
		int[][][][][][][] map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		int i1 = (index >>> 24) & 0xf;
		int[][][][][][] map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		int i2 = (index >>> 20) & 0xf;
		int[][][][][] map3 = map2[i2];
		if (map3 == null)
			return NOT_FOUND;

		int i3 = (index >>> 16) & 0xf;
		int[][][][] map4 = map3[i3];
		if (map4 == null)
			return NOT_FOUND;

		int i4 = (index >>> 12) & 0xf;
		int[][][] map5 = map4[i4];
		if (map5 == null)
			return NOT_FOUND;

		int i5 = (index >>> 8) & 0xf;
		int[][] map6 = map5[i5];
		if (map6 == null)
			return NOT_FOUND;

		int i6 = (index >>> 4) & 0xf;
		int[] map7 = map6[i6];
		if (map7 == null)
			return NOT_FOUND;

		int i7 = index & 0xf;
		return map7[i7];
	}
}
