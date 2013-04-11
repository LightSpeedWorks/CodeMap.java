/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMap {
	static final int NOT_FOUND = -1;
	static final int MAX_INDEX = 0x100;
	int[][][][] map = null;

	/**
	 * creates character code mapping table
	 * {文字コードマッピングテーブル作成}
	 */
	public CodeMap() {
	}

	/**
	 * deletes character code mapping table
	 * {文字コードマッピングテーブル削除}
	 */
	public void delete() {
		if (map == null)
			return;

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
						map3[i3] = 0;
					map2[i2] = null;
				}
				map1[i1] = null;
			}
			map[i0] = null;
		}
		map = null;
	}

	/**
	 * sets value to character code mapping table
	 * {文字コードマッピングに値を設定}
	 *
	 * @param index integer index {整数インデックス}
	 * @param value integer value {整数値}
	 */
	public CodeMap set(int index, int value) {
		int i0 = index >>> 24;
		int i1 = (index >>> 16) & 0xff;
		int i2 = (index >>> 8) & 0xff;
		int i3 = index & 0xff;
		int[][][] map1;
		int[][] map2;
		int[] map3;

		//String.format("CodeMap set[%02x %02x %02x %02x]= %04x\n", i0, i1, i2, i3, value);

		if (map == null) {
			map = new int[MAX_INDEX][][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map[i] = null;
			//System.out.println("0: map[0-255] allocated");
		}

		map1 = map[i0];
		if (map1 == null) {
			map[i0] = map1 = new int[MAX_INDEX][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = null;
			//System.out.println("1: map[" + i0 + "][0-255] allocated");
		}

		map2 = map1[i1];
		if (map2 == null) {
			map1[i1] = map2 = new int[MAX_INDEX][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map2[i] = null;
			//System.out.println("2: map[" + i0 + "][" + i1 + "][0-255] allocated");
		}

		map3 = map2[i2];
		if (map3 == null) {
			map2[i2] = map3 = new int[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = 0;
			//System.out.println("3: map[" + i0 + "][" + i1 + "][" + i2 + "][0-255] allocated");
		}

		//System.out.println("4: map[" + i0 + "][" + i1 + "][" + i2 + "][" + i3 + "]=" + value);
		map3[i3] = value;
		return this;
	}

	/**
	 * gets value from character code mapping table
	 * {文字コードマッピングの値を取得}
	 *
	 * @param index integer index {整数インデックス}
	 * @return integer value {整数値}
	 */
	public int get(int index) {
		int i0 = index >>> 24;
		int i1 = (index >>> 16) & 0xff;
		int i2 = (index >>> 8) & 0xff;
		int i3 = index & 0xff;
		int[][][] map1;
		int[][] map2;
		int[] map3;

		//String.format("CodeMap get[%02x %02x %02x %02x]\n", i0, i1, i2, i3);

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

		int value = map3[i3];

		//String.format("CodeMap get[%02x %02x %02x %02x]= %04x\n", i0, i1, i2, i3, value);
		return value;
	}
}
