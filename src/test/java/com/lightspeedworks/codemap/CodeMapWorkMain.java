/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapWorkMain {
	static final int MAX_LOOP_COUNT = 0xffff;
	static final int MAX_TEST_COUNT = 20;

	/**
	 * main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		CodeMap map = new CodeMap();

		System.out.println("[0] = " + map.get(0));
		map.set(0, 0);
		System.out.println("[0] = " + map.get(0));
		map.delete();

		for (int k = 0; k < MAX_TEST_COUNT; ++k) {
			long startTime = System.currentTimeMillis();

			for (int i = 0; i <= MAX_LOOP_COUNT; ++i)
				map.set(i, i);
			for (int i = 0; i <= MAX_LOOP_COUNT; ++i)
				if (i != map.get(i)) {
					throw new Error("WRONG DATA");
				}
			//map.delete();
			for (int i = 0; i <= MAX_LOOP_COUNT; ++i)
				map.set(i, i);
			for (int i = 0; i <= MAX_LOOP_COUNT; ++i)
				if (i != map.get(i)) {
					throw new Error("WRONG DATA");
				}

			long deltaTime = System.currentTimeMillis() - startTime;
			System.out.println(String.format("%02d: %6.3f", k, deltaTime/1000.0));
		}
	}
}
