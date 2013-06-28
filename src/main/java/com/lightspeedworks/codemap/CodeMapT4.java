package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 *
 * @param <T>
 *            type
 */
public class CodeMapT4<T> implements ICodeMap {
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
	T[][][][] map;

	/**
	 * creates character code mapping table. {文字コードマッピングテーブル作成}
	 */
	@SuppressWarnings("unchecked")
	public CodeMapT4() {
		map = (T[][][][]) new Object[MAX_INDEX][][][];
		for (int i = 0; i < MAX_INDEX; ++i)
			map[i] = null;
	}

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i0 = 0; i0 < MAX_INDEX; ++i0) {
			T[][][] map1 = map[i0];
			if (map1 == null)
				continue;
			for (int i1 = 0; i1 < MAX_INDEX; ++i1) {
				T[][] map2 = map1[i1];
				if (map2 == null)
					continue;
				for (int i2 = 0; i2 < MAX_INDEX; ++i2) {
					T[] map3 = map2[i2];
					if (map3 == null)
						continue;
					for (int i3 = 0; i3 < MAX_INDEX; ++i3)
						map3[i3] = null;
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
	@SuppressWarnings("unchecked")
	public CodeMapT4<T> set(int index, int value) {
		int i0 = index >>> 24;
		int i1 = (index >>> 16) & 0xff;
		int i2 = (index >>> 8) & 0xff;
		int i3 = index & 0xff;
		T[][][] map1;
		T[][] map2;
		T[] map3;

		map1 = map[i0];
		if (map1 == null) {
			map[i0] = map1 = (T[][][]) new Object[MAX_INDEX][][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map1[i] = null;
		}

		map2 = map1[i1];
		if (map2 == null) {
			map1[i1] = map2 = (T[][]) new Object[MAX_INDEX][];
			for (int i = 0; i < MAX_INDEX; ++i)
				map2[i] = null;
		}

		map3 = map2[i2];
		if (map3 == null) {
			map2[i2] = map3 = (T[]) new Object[MAX_INDEX];
			for (int i = 0; i < MAX_INDEX; ++i)
				map3[i] = null;
		}

		map3[i3] = (T) (Object) value;
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
		int i1 = (index >>> 16) & 0xff;
		int i2 = (index >>> 8) & 0xff;
		int i3 = index & 0xff;
		T[][][] map1;
		T[][] map2;
		T[] map3;

		map1 = map[i0];
		if (map1 == null)
			return NOT_FOUND;

		map2 = map1[i1];
		if (map2 == null)
			return NOT_FOUND;

		map3 = map2[i2];
		if (map3 == null)
			return NOT_FOUND;

		T value = map3[i3];
		return (Integer) (Object) value;
	}
}