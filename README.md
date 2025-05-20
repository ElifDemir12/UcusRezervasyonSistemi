Proje Hakkında
-Bu proje, Nesneye Dayalı Programlama (OOP) dersinde yapılmak üzere geliştirilmiş basit bir uçuş rezervasyon sistemidir. Konsol tabanlı çalışan bu uygulama ile kullanıcılar farklı lokasyonlar arasında uçuş seferlerini görüntüleyebilir, uygun koltuk sayısı doğrultusunda rezervasyon yapabilirler.

Özellikler
-Uçak, Lokasyon ve Uçuş bilgileri nesne tabanlı olarak modellenmiştir.
-Kullanıcıya mevcut uçuşlar listelenir.
-Uçuş seçildikten sonra kaç koltuk rezervasyonu yapılacağı sorulur.
-E-posta adresi doğrulaması yapılır; geçerli e-posta adresi '@' karakteri içermelidir.
-Uçuşun boş koltuk kapasitesi kontrol edilir, yeterli boşluk yoksa rezervasyon engellenir.
-Rezervasyon bilgileri (ad, soyad, yaş, e-posta, rezervasyon yapılan koltuk sayısı ve uçuş detayları) konsolda gösterilir.

Kullanılan Teknolojiler
-Java SE (JDK 8 veya üstü önerilir)
-Konsol (Terminal) tabanlı arayüz

Sınıf Yapısı
-Plane : Uçak bilgilerini (model, marka, seri no, koltuk kapasitesi) tutar.
-Location : Uçuş lokasyonlarını (ülke, şehir, havaalanı, aktiflik durumu) içerir.
-Flight : Uçuş detayları (kalkış ve varış lokasyonu, uçuş saati, uçak, fiyat, rezerve edilen koltuk sayısı) yönetilir.
-Reservation : Yapılan rezervasyon bilgileri (yolcu bilgileri, e-posta, koltuk sayısı ve uçuş) saklanır.

Nasıl Çalıştırılır?
-Proje dosyasını IntelliJ IDEA veya herhangi bir Java IDE'sinde açın.
-Main sınıfındaki main metodunu çalıştırın.
-Konsolda listelenen uçuşlar arasından bir seçim yapın.
-Kaç koltuk rezerve etmek istediğinizi girin.
-Kişisel bilgilerinizi ve geçerli e-posta adresinizi girin.
-Rezervasyon başarılıysa detaylar ekranda gösterilecektir.

Geliştirme Notları
-Uçuş, uçak ve lokasyon bilgileri sabit olarak program içinde tanımlanmıştır.
-Rezervasyonlar sadece uygulama çalıştığı sürece hafızada tutulur; dosya kaydı veya veri tabanı entegrasyonu bulunmamaktadır.
-E-posta doğrulaması sadece '@' karakteri kontrolü ile sınırlıdır.
-Daha kapsamlı validasyonlar ve dosya/database işlemleri ileride eklenebilir.
