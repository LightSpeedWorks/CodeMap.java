package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 *
 * @param <T>
 *            type
 */
public class CodeMapT<T> {
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
	T[][][] map = null;

	/**
	 * map short cut.
	 */
	@SuppressWarnings("unchecked")
	final T[][] map10 = (T[][]) new Object[MAX_INDEX_ONE][];

	/**
	 * deletes character code mapping table. {文字コードマッピングテーブル削除}
	 */
	public void clear() {
		for (int i = 0; i < MAX_INDEX_ONE; ++i)
			map10[i] = null;

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
	@SuppressWarnings("unchecked")
	public CodeMapT<T> set(final int index, final T value) {
		final int i0 = index >>> 24;
		T[][] map1;

		if (i0 != 0) {
			if (map == null)
				map = (T[][][]) new Object[MAX_INDEX_ZERO][][];

			map1 = map[i0];
			if (map1 == null)
				map1 = map[i0] = (T[][]) new Object[MAX_INDEX_ONE][];
		} else
			map1 = map10;

		final int i1 = (index >>> 12) & 0xfff;
		T[] map2 = map1[i1];
		if (map2 == null)
			map2 = map1[i1] = (T[]) new Object[MAX_INDEX_TWO];

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
	public T get(final int index) {
		final int i0 = index >>> 24;
		final T[][] map1;

		if (i0 != 0) {
			if (map == null)
				return null; // NOT_FOUND;

			map1 = map[i0];
			if (map1 == null)
				return null; // NOT_FOUND;
		} else {
			map1 = map10;
		}

		final T[] map2 = map1[(index >>> 12) & 0xfff];
		if (map2 == null)
			return null; // NOT_FOUND;

		return map2[index & 0xfff];
	}
}
