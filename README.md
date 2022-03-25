> **Konu:**
- Bir marketteki ürünlerin satış fiyatlarına göre son fiyatlarını belirleyen servisin Spring Boot Framework
kullanılarak yazılması ve isteğe bağlı olarak önyüzünün yazılması.
-------------------------------------------------------------------------
> **İçerik:**

- Projenin backend tarafı Java Spring ile yazilmiştir.
- Projenin Frondend tarafı Vue ile yazilmiştir.
- Projede Database için Postgresql kullanılmıştır.
-----------------------------------------------------------------------------------------
- Proje kullanılmaya başlamadan önce ilk KDV değerlerinin atanabilmesi için 2 yol izlenebilir.
1. Api üzerinden api/v1/kdv adresine post isteği ile ilk değerler atanabilmektedir.
2. Postgresql üzerinde aşağıda belirtilen script satırları çalıştırılmalıdır. 

- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (1,1,'GIDA');
- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (2,8,'KIRTASIYE');
- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (3,8,'GIYECEK');
- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (4,18,'TEKLONOJI');
- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (5,18,'TEMIZLIK');
- INSERT INTO kdv (id,kdv_rate,product_type) VALUES (6,18,'DIGER');
- ---------------------------------------------------------------------------------
- Open API Specification olarak Swagger kullanılmıştır. Swagger üzerinden projeyi incelemek için [Tıklayınız](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/)

- ---------------------------------------------------------------------------------
- Projenin isterler dökümanı aşağıdaki gibidir.
- ---------------------------------------------------------------------------------












# Bitirme Projesi

Projenin Konusu:
Bir marketteki ürünlerin satış fiyatlarına göre son fiyatlarını belirleyen servisin Spring Boot Framework
kullanılarak yazılması ve isteğe bağlı olarak önyüzünün yazılması.

> **Gereksinimler:**

> **Backend:**

- Kullanıcıdan kullanıcı adı, şifre, isim, soy isim bilgilerini alarak sisteme kayıt yapılır.
- Sisteme kayıtlı kullanıcılar market ürünlerinin veri girişini yapabilir.
- Ürün türlerine göre KDV oranları değişiklik göstermektedir. Bu oranlar aşağıdaki tabloda
belirtilmiştir. __**Zaman zaman KDV oranları değişiklik gösterebilmektedir.**__

![Image](https://www.linkpicture.com/q/Untitled_395.png)


- Ürün için veri girişi yapacak kullanıcı; ürünün adı, ürünün türü ve vergisiz satış fiyatı alanlarını
doldurur. Her bir ürün için KDV Tutarı ve ürünün son fiyatı da hesaplanarak sisteme kaydedilir.
> **Kurallar ve gereksinimler:**
- Sisteme yeni kullanıcı tanımlanabilir, güncellenebilir ve silinebilir.
- Sisteme yeni ürünler tanımlanabilir, güncellenebilir ve silinebilir.
- Ürünlerin fiyatları güncellenebilir.
- KDV oranları değiştiğinde sistemdeki ürünlere de bu değişiklik yansıtılmalıdır. Herhangi bir hata
durumunda tüm işlemler geri alınmalıdır.
- Tüm ürünler listelenebilmelidir.
- Ürün türlerine göre ürünler listelenebilmelidir.
- Belirli bir fiyat aralığındaki ürünler listelenebilmelidir.
- Ürün türlerine göre aşağıdaki gibi detay veri içeren bir bilgilendirme alınabilmelidir.

![Image](https://www.linkpicture.com/q/22_57.png)

> Validasyonlar:
- Aynı kullanıcı adı ile kullanıcı tanımı yapılamaz.
- Kullanıcı girişi kullanıcı adı & şifre kombinasyonu ile yapılır.
- Ürün türü, fiyatı, adı gibi alanlar boş olamaz.
- Ürün fiyatı sıfır ya da negatif olamaz.
- KDV oranı negatif olamaz.
> Authentication:
- Güvenli endpointler kullanınız. (jwt, bearer vs. )
> Response:
- Başarılı ve başarısız responselar için modeller tanımlayın ve bunları kullanın.
> Dökümantasyon:
- Open API Specification (Swagger tercih sebebi)
> Exception Handling:
- Hatalı işlemler için doğru hata kodlarının dönüldüğünden emin olunuz.
> Test:
- Unit ve integration testleri yazınız. 
