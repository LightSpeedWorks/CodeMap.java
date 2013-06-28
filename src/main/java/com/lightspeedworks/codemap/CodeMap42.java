package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap42 implements ICodeMap {
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
	 * map short cut.
	 */
	final int[][] map200 = new int[MAX_INDEX][];

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMap42() {
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i2 = 0; i2 < MAX_INDEX; ++i2)
			map200[i2] = null;

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
	public CodeMap42 set(final int index, final int value) {
		final int i2 = (index >>> 8) & 0xff;
		final int i3 = index & 0xff;

		if ((index >>> 16) == 0) {
			int[] map3 = map200[i2];

			if (map3 == null) {
				map3 = map200[i2] = new int[MAX_INDEX];
				for (int i = 0; i < MAX_INDEX; ++i)
					map3[i] = NOT_FOUND;
			}

			map3[i3] = value;
			return this;
		}

		final int i0 = index >>> 24;
		int[][][] map1 = map[i0];
		if (map1 == null)
			map1 = map[i0] = new int[MAX_INDEX][][];

		final int i1 = (index >>> 16) & 0xff;
		int[][] map2 = map1[i1];
		if (map2 == null)
			map2 = map1[i1] = new int[MAX_INDEX][];

		int[] map3 = map2[i2];
		if (map3 == null) {
			map3 = map2[i2] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = NOT_FOUND;
		}

		map3[i3] = value;
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
		final int i2 = (index >>> 8) & 0xff;
		final int i3 = index & 0xff;

		if ((index >>> 16) == 0) {
			int[] map3 = map200[i2];
			if (map3 == null)
				return NOT_FOUND;

			return map3[i3];
		}

		final int i0 = index >>> 24;
		int[][][] map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		final int i1 = (index >>> 16) & 0xff;
		int[][] map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		int[] map3 = map2[i2];
		if (map3 == null)
			return NOT_FOUND;

		return map3[i3];
	}
}
