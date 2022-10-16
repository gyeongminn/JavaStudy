package Practice;

abstract class PairMap {
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);

    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    private int length;

    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
    }

    @Override
    String get(String key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    void put(String key, String value) {
        if (length() == keyArray.length) return;
        keyArray[length] = key;
        valueArray[length++] = value;
    }

    @Override
    String delete(String key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                String removed = valueArray[i];
                valueArray[i] = null;
                keyArray[i] = null;
                return removed;
            }
        }
        return null;
    }

    @Override
    int length() {
        return length;
    }
}

class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}