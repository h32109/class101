package store;

import proxy.SellProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    protected Map<Integer, Product> products;
    private SellProxy sellProxy;

    public Store() {
        products = new HashMap<>();
        sellProxy = new SellProxy();
        addProduct("class", 16374,
                "스마트스토어로 월 100만원 만들기, 평범한 사람이 돈을 만드는 비법", 151950, 99999);
        addProduct("class", 26825,
                "해금, 특별하고 아름다운 나만의 반려악기", 114500, 99999);
        addProduct("class", 65625,
                "일상에 따뜻한 숨결을 불어넣어요, 반지수와 함께하는 아이패드 드로잉", 174500, 99999);
        addProduct("kit", 91008,
                "작고 쉽게 그려요 - 부담없이 시작하는 수채화 미니 키트", 151950, 99999);
        addProduct("kit", 9236,
                "하루의 시작과 끝, 욕실의 포근함을 선사하는 천연 비누", 9900, 22);
        addProduct("class", 55527,
                "코바늘로 인형을 만들자! 시은맘의 꼼지락 작업실", 299500, 99999);
        addProduct("class", 2344,
                "일상 유튜버 슛뚜의 감성을 그대로. 영화같은 브이로그 제작법", 184500, 99999);
        addProduct("kit", 60538,
                "시작에 대한 부담을 덜다. 가격 절약 아이패드 특가전", 135800, 7);
        addProduct("kit", 78156,
                "일상을 따뜻하게 채우는 썬캐쳐와 무드등", 45000, 16);
        addProduct("class", 53144,
                "여행 드로잉, 꿈만 꾸지 마세요. 핀든아트와 여행, 그리다", 249500, 99999);
        addProduct("class", 78311,
                "사각사각 손글씨의 낭만, 펜크래프트의 한글 정자체 펜글씨", 209500, 99999);
        addProduct("kit", 97166,
                "이렇게 멋진 수채화 키트,어때요? 클래스101과 고넹이화방이 기획한 3가지 수채화 키트", 96900, 5);
        addProduct("class", 83791,
                "월급으로 만족하지 못하는 분들을 위한 아마존/이베이 입문", 178500, 99999);
        addProduct("kit", 58395,
                "선과 여백으로 채우는 2020년 캘린더와 엽서", 18620, 31);
        addProduct("kit", 39712,
                "집에서 느끼는 겨울의 묵직한 포근함, 플랜테리어 아이템", 17600, 8);
        addProduct("class", 96558,
                "사진 입문자를 위한 쉽게 배우고 빨리 써먹는 사진과 라이트룸", 234500, 99999);
        addProduct("kit", 42031,
                "나만의 음악을 만들기 위한 장비 패키지", 209000, 2);
        addProduct("class", 45947,
                "일러스트레이터 집시의 매력적인 얼굴 그리기", 249500, 99999);
        addProduct("class", 74218,
                "나만의 문방구를 차려요! 그리지영의 타블렛으로 굿즈 만들기", 191600, 99999);
        addProduct("class", 28448,
                "당신도 할 수 있다! 베테랑 실무자가 알려주는 모션그래픽의 모든 것", 152200, 99999);
    }

    public void addProduct(String type, int productSeq, String name, int price, int stock) {
        Product product = setProduct(type, productSeq, name, price, stock);
        products.put(product.productSeq,product);
    }

    public Product setProduct(String type, int productSeq, String name, int price, int stock) {
        Product product = null;
        if (type.equals("class")) product = new Class(productSeq, name, price, stock);
        if (type.equals("kit")) product = new Kit(productSeq, name, price, stock);
        return product;
    }

    public void showProductList() {
        System.out.println("상품번호                              상품명            판매가격             재고수");
        sellProxy.sortByKey(products).values().forEach(s -> System.out.println(
                String.format("%s %s     %d     %d",
                        s.productSeq,
                        s.name,
                        s.price,
                        s.stock)
        ));
        System.out.println();
    }

    public Product getProduct(int productSeq){
        return products.get(productSeq);
    }

    public List<Integer> getProductSeqs(){
        List<Integer> productSeqs = new ArrayList<>();
        products.values().forEach(s-> productSeqs.add(s.productSeq));
        return productSeqs;
    }


}
