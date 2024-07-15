import org.testng.annotations.DataProvider;
public class MaasHesaplamaDP {
    @DataProvider(name = "gelirDataProvider")
    public static Object[][] gelirDataProvider() {
        return new Object[][] {
                { 100, 20, 2000.0 },   // katsayi, gunSayisi, expectedMaas
                { 200, 30, 7100.0 },   // katsayi, gunSayisi, expectedMaas
                { 200, 10, 2500.0 },   // katsayi, gunSayisi, expectedMaas
                { 150, 26, 4750.0 }    // katsayi, gunSayisi, expectedMaas
        };
    }
}
