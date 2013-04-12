/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap8 implements ICodeMap {
	static final int NOT_FOUND = -1;
	static final int MAX_INDEX = 0x10;
	int[][][][][][][][] map = null;

	/**
	 * creates character code mapping table {文字コードマッピングテーブル作成}
	 */
	public CodeMap8() {
	}

	/**
	 * deletes character code mapping table {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		if (map == null)
			return;

		for (int i0 = 0; i0 < MAX_INDEX; ++i0) {
			int[][][][][][][] map1 = map[i0];
			if (map1 == null)
				continue;
			for (int i1 = 0; i1 < MAX_INDEX; ++i1) {
				int[][][][][][] map2 = map1[i1];
				if (map2 == null)
					continue;
				for (int i2 = 0; i2 < MAX_INDEX; ++i2) {
					int[][][][][] map3 = map2[i2];
					if (map3 == null)
						continue;
					for (int i3 = 0; i3 < MAX_INDEX; ++i3) {
						int[][][][] map4 = map3[i3];
						if (map4 == null)
							continue;
						for (int i4 = 0; i4 < MAX_INDEX; ++i4) {
							int[][][] map5 = map4[i4];
							if (map5 == null)
								continue;
							for (int i5 = 0; i5 < MAX_INDEX; ++i5) {
								int[][] map6 = map5[i5];
								if (map6 == null)
									continue;
								for (int i6 = 0; i6 < MAX_INDEX; ++i6) {
									int[] map7 = map6[i6];
									if (map7 == null)
										continue;
									for (int i7 = 0; i7 < MAX_INDEX; ++i7) {
										map7[i7] = NOT_FOUND;
									}
									map6[i6] = null;
								}
								map5[i5] = null;
							}
							map4[i4] = null;
						}
						map3[i3] =null;
					}
					map2[i2] = null;
				}
				map1[i1] = null;
			}
			map[i0] = null;
		}
		map = null;
	}

	/**
	 * sets value to character code mapping table {文字コードマッピングに値を設定}
	 *
	 * @param index
	 *            integer index {整数インデックス}
	 * @param value
	 *            integer value {整数値}
	 */
	public CodeMap8 set(int index, int value) {
		int i0 = index >>> 28;
		int i1 = (index >>> 24) & 0xf;
		int i2 = (index >>> 20) & 0xf;
		int i3 = (index >>> 16) & 0xf;
		int i4 = (index >>> 12) & 0xf;
		int i5 = (index >>> 8) & 0xf;
		int i6 = (index >>> 4) & 0xf;
		int i7 = index & 0xf;
		int[][][][][][][] map1;
		int[][][][][][] map2;
		int[][][][][] map3;
		int[][][][] map4;
		int[][][] map5;
		int[][] map6;
		int[] map7;

		if (map == null) {
			map = new int[MAX_INDEX][][][][][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map[i] = null;
		}

		map1 = map[i0];
		if (map1 == null) {
			map1 = map[i0] = new int[MAX_INDEX][][][][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = null;
		}

		map2 = map1[i1];
		if (map2 == null) {
			map2 = map1[i1] = new int[MAX_INDEX][][][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map2[i] = null;
		}

		map3 = map2[i2];
		if (map3 == null) {
			map3 = map2[i2] = new int[MAX_INDEX][][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = null;
		}

		map4 = map3[i3];
		if (map4 == null) {
			map4 = map3[i3] = new int[MAX_INDEX][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map4[i] = null;
		}

		map5 = map4[i4];
		if (map5 == null) {
			map5 = map4[i4] = new int[MAX_INDEX][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map5[i] = null;
		}

		map6 = map5[i5];
		if (map6 == null) {
			map6 = map5[i5] = new int[MAX_INDEX][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map6[i] = null;
		}

		map7 = map6[i6];
		if (map7 == null) {
			map7 = map6[i6] = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map7[i] = NOT_FOUND;
		}

		map7[i7] = value;
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
		int i0 = index >>> 28;
		int i1 = (index >>> 24) & 0xf;
		int i2 = (index >>> 20) & 0xf;
		int i3 = (index >>> 16) & 0xf;
		int i4 = (index >>> 12) & 0xf;
		int i5 = (index >>> 8) & 0xf;
		int i6 = (index >>> 4) & 0xf;
		int i7 = index & 0xf;
		int[][][][][][][] map1;
		int[][][][][][] map2;
		int[][][][][] map3;
		int[][][][] map4;
		int[][][] map5;
		int[][] map6;
		int[] map7;

		if (map == null)
			return NOT_FOUND;

		map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		map3 = map2[i2];
		if (map3 == null)
			return NOT_FOUND;

		map4 = map3[i3];
		if (map4 == null)
			return NOT_FOUND;

		map5 = map4[i4];
		if (map5 == null)
			return NOT_FOUND;

		map6 = map5[i5];
		if (map6 == null)
			return NOT_FOUND;

		map7 = map6[i6];
		if (map7 == null)
			return NOT_FOUND;

		return map7[i7];
	}
}
