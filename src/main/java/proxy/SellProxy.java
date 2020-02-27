package proxy;

import store.Product;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SellProxy {
    public Map<Integer,Product> sortByKey(Map<Integer, Product> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer,Product>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public String toNumFormat(int num) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(num);
    }
}
