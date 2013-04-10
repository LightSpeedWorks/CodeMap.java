CodeMap.java
==========================

LightSpeedWorks pages {光速工房}

Character code mapping virtual array library for Java
{文字コードマッピング仮想配列ライブラリ(Java向け)}

[LightSpeedWorks/CodeMap.java#readme] (https://github.com/LightSpeedWorks/CodeMap.java#readme "LightSpeedWorks/CodeMap.java#readme")

## usage: {使用方法:}

## CodeMap.get(int index), set(int index, int value)

``` java
import com.lightspeedworks.codemap.CodeMap;

CodeMap map = new CodeMap();

int code = map.get(0);  // returns -1 or CodeMap.NOT_FOUND

map.set(0, 0);

code = map.get(0);
```
