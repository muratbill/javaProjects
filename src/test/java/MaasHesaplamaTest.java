import com.newrdmb.ders18.odev13.MaasHesaplama;
import org.testng.Assert;
import org.testng.annotations.*;



    public class MaasHesaplamaTest {

        MaasHesaplama hesaplama;

        @BeforeSuite
        public void beforeSuite() {
            System.out.println("This runs before the entire test suite.");
        }

        @BeforeClass
        public void beforeClass() {
            System.out.println("This runs before the MaasHesaplamaTest class.");
        }

        @BeforeMethod
        public void beforeMethod() {
            System.out.println("This runs before each test method.");
            hesaplama = new MaasHesaplama();
        }

        @Test
        public void testGelirGunSayisiLessThan26() {
            hesaplama.katsayi = 100; // Set your katsayi value
            hesaplama.gelir(20);
            Assert.assertEquals(hesaplama.maas, 2000.0, "DP kullanmadan Maas hesaplama hatalı.");
        }

        @Test
        public void testGelirGunSayisiMoreThan25() {
            hesaplama.katsayi = 100; // Set your katsayi value
            hesaplama.gelir(30);
            Assert.assertEquals(hesaplama.maas, 3500.0, "DP kullanmadan Maas hesaplama hatalı.");
        }
        @Test(dataProvider = "gelirDataProvider", dataProviderClass = MaasHesaplamaDP.class)
        public void testGelir(int katsayi, int gunSayisi, double expectedMaas) {
            hesaplama.katsayi = katsayi;
            hesaplama.gelir(gunSayisi);
            Assert.assertEquals(hesaplama.maas, expectedMaas, "Maas hesaplama hatalı.");
        }
        @AfterMethod
        public void afterMethod() {
            System.out.println("This runs after each test method.");
        }

        @AfterClass
        public void afterClass() {
            System.out.println("This runs after the MaasHesaplamaTest class.");
        }

        @AfterSuite
        public void afterSuite() {
            System.out.println("This runs after the entire test suite.");
        }
    }


