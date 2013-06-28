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
	int[][][][] map;

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	public CodeMap4() {
		map = new int[MAX_INDEX][][][];
		for (int i = 0; i < MAX_INDEX; ++i)
			map[i] = null;
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i0 = 0; i0 < MAX_INDEX; ++i0) {
			int[][][] map1 = map[i0];
			if (map1 == null)
				continue;
			for (int i1 = 0; i1 < MAX_INDEX; ++i1) {
				int[][] map2 = map1[i1];
				if (map2 == null)
					continue;
				for (int i2 = 0; i2 < MAX_INDEX; ++i2) {
					int[] map3 = map2[i2];
					if (map3 == null)
						continue;
					for (int i3 = 0; i3 < MAX_INDEX; ++i3)
						map3[i3] = NOT_FOUND;
					map2[i2] = null;
				}
				map1[i1] = null;
			}
			map[i0] = null;
		}
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
	public CodeMap4 set(int index, int value) {
		int i0 = index >>> 24;
		int[][][] map1 = map[i0];
		if (map1 == null) {
			map1 = map[i0] = new int[MAX_INDEX][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = null;
		}

		int i1 = (index >>> 16) & 0xff;
		int[][] map2 = map1[i1];
		if (map2 == null) {
			map2 = map1[i1] = new int[MAX_INDEX][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map2[i] = null;
		}

		int i2 = (index >>> 8) & 0xff;
		int[] map3 = map2[i2];
		if (map3 == null) {
			map3 = map2[i2] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = NOT_FOUND;
		}

		int i3 = index & 0xff;
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
	public int get(int index) {
		int i0 = index >>> 24;
		int[][][] map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		int i1 = (index >>> 16) & 0xff;
		int[][] map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		int i2 = (index >>> 8) & 0xff;
		int[] map3 = map2[i2];
		if (map3 == null)
			return NOT_FOUND;

		int i3 = index & 0xff;
		return map3[i3];
	}
}
